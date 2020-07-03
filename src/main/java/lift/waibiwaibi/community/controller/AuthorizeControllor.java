package lift.waibiwaibi.community.controller;

import lift.waibiwaibi.community.dto.AccessTokenDTO;
import lift.waibiwaibi.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeControllor {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("Iv1.fe629099e5be19e9");
        accessTokenDTO.setClient_secret("ea62b607ac50f0b7725d8e3d5866937109676145");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
