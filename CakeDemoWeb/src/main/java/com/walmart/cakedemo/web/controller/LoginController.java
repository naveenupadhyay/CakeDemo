
package com.walmart.cakedemo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.webapputils.base.cache.EmailVerificationCode;
import com.webapputils.base.utils.StringUtils;
import com.webapputils.base.utils.ValidatorUtils;
import com.walmart.cakedemo.web.controller.form.SignupForm;
import com.walmart.cakedemo.web.utils.PathResolver;
import com.walmart.cakedemo.web.utils.CakeDemoWebUtils;
import com.walmart.cakedemo.web.response.SystemResponse;
import com.walmart.cakedemo.web.response.SystemResponse.ResponseStatus;
import com.walmart.cakedemo.web.utils.WebContextUtils;
import com.walmart.cakedemo.entity.User;
import com.walmart.cakedemo.utils.EncryptionUtils;
import com.walmart.cakedemo.web.security.CakeDemoUser;
import com.walmart.cakedemo.db.users.IUserRoleService;
import com.walmart.cakedemo.db.users.IUserService;

@Controller
public class LoginController {

    public static String        REDIRECT_PATH      = "spring-security-redirect";
    public static String        THIRD_PARTY_SOURCE = "facebookgoogleyahoo";

    @Autowired
    private IUserService        userService;

    @Autowired
    IUserRoleService            userRoleService;

    private static final Logger LOG                = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String loginPage(@RequestParam(value = "authenticated", required = false) Boolean authenticated, @RequestParam(value = "source", required = false) String source,
            @RequestParam(value = "targetUrl", required = false) String targetUrl, ModelMap model) {
        SignupForm signupForm = new SignupForm();
        if (StringUtils.isNotEmpty(source)) {
            signupForm.setSource(source);
        }
        if (StringUtils.isNotEmpty(targetUrl)) {
            signupForm.setTargetUrl(targetUrl);
        }
        model.addAttribute("signupForm", signupForm);

        CakeDemoUser user = WebContextUtils.getCurrentUser();
        if (user != null) {
            return "redirect:" + CakeDemoWebUtils.determineAutoRedirctUrl(user);
        }

        if (authenticated != null && !authenticated) {
            return "redirect:login?systemcode=508";
        } else {
            return "login/login";
        }
    }
}
