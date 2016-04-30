package bug;

import com.bug.ExceptionTypeOne;
import com.bug.MainClass;
import com.bug.MockSecurityContext;
import com.bug.MyCustomExceptionThrowerController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.naming.NamingException;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by amir amirhoshangi@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainClass.class)
@WebAppConfiguration
public class StressTest {

    @Autowired
    MyCustomExceptionThrowerController myCustomExceptionThrowerController;


    @Resource
    public FilterChainProxy springSecurityFilterChain;

    @Autowired
    public WebApplicationContext webApplicationContext;
    public MockMvc mockMvc;

    @Autowired
    MockSecurityContext mockSecurityContext;


    @Before
    public void setupMockMvc() throws NamingException {

        // setup mock MVC
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .addFilters(this.springSecurityFilterChain)
                .build();
    }

    @Test
    public void test() throws ExceptionTypeOne {

        for (int i = 0; i < 100; i++) {

            myCustomExceptionThrowerController.throwExceptionTypeOne();
            myCustomExceptionThrowerController.throwExceptionTypeTwo();
        }

    }

    @Test
    public void getCardOwnerRestTest() throws IOException {

        MockHttpSession session = getSession();
        MvcResult mvcResult = null;
        try {
            mvcResult = mockMvc.perform(get("/api/exception-one")
                  //  .content(JacksonMapperConfig.getObjectMapper().writeValueAsString(cardOwnerDTO))
                    .session(session)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MockHttpSession getSession() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority grantedAuthority = new GrantedAuthority() {
            public String getAuthority() {
                return "Asghar";
            }
        };
        grantedAuthorities.add(grantedAuthority);
        AnonymousAuthenticationToken anonymousAuthenticationToken = new AnonymousAuthenticationToken("asghar",
                new Principal() {
                    public String getName() {
                        return "asghar";
                    }
                }, grantedAuthorities);

        MockHttpSession session = new MockHttpSession();
        mockSecurityContext.setAuthentication(anonymousAuthenticationToken);
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, mockSecurityContext);
        return session;
    }
}
