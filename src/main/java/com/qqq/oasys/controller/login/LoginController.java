package com.qqq.oasys.controller.login;

import com.qqq.oasys.common.utils.VerifyCodeUtils;
import com.qqq.oasys.mapper.UserMapper;
import com.qqq.oasys.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author Johnson
 * 2021/2/20
 */
@Controller
@RequestMapping("/")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    public static final String CAPTCHA_KEY = "session_captcha";


    /**
     * 登录界面的显示
     *
     * @return
     */
    @RequestMapping(value = "logins", method = RequestMethod.GET)
    public String login() {
        return "login/login";
    }

    @RequestMapping("loginout")
    public String loginout(HttpSession session) {
        session.removeAttribute("userId");
        return "redirect:/logins";
    }

    /**
     * 登录检查；
     * 1、根据(用户名或电话号码)+密码进行查找
     * 2、判断使用是否被冻结；
     *
     * @return
     * @throws UnknownHostException
     */
    @RequestMapping(value = "logins", method = RequestMethod.POST)
    public String loginCheck(HttpSession session, HttpServletRequest req, Model model) throws UnknownHostException {
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password");
        String ca = req.getParameter("code").toLowerCase();
        String sesionCode = (String) req.getSession().getAttribute(CAPTCHA_KEY);
        model.addAttribute("userName", userName);
//        if (!ca.equals(sesionCode.toLowerCase())) {
//            logger.info("验证码输入错误!");
//            model.addAttribute("errormess", "验证码输入错误!");
//            req.setAttribute("errormess", "验证码输入错误!");
//            return "login/login";
//        }
        /*
         * 将用户名分开查找；用户名或者电话号码；
         * */
        User user = userMapper.findOneUser(userName, password);
        if (Objects.isNull(user)) {
            logger.info("{}", user.toString());
            logger.info("账号或密码错误!");
            model.addAttribute("errormess", "账号或密码错误!");
            return "login/login";
        }
        logger.info("是否被锁：" + user.getIsLock());
        if (user.getIsLock() == 1) {
            logger.info("账号已被冻结!");
            model.addAttribute("errormess", "账号已被冻结!");
            return "login/login";
        }
        Object sessionId = session.getAttribute("userId");
        logger.info("{}", user.toString());
        if (sessionId == user.getUserId()) {
            logger.info("当前用户已经登录了；不能重复登录");
            model.addAttribute("hasmess", "当前用户已经登录了；不能重复登录");
            session.setAttribute("thisuser", user);
            return "login/login";
        } else {
            session.setAttribute("userId", user.getUserId());
//            Browser browser = UserAgent.parseUserAgentString(req.getHeader("User-Agent")).getBrowser();
//            Version version = browser.getVersion(req.getHeader("User-Agent"));
//            String info = browser.getName() + "/" + version.getVersion();
            String ip = InetAddress.getLocalHost().getHostAddress();
            /*新增登录记录*/
//            ulService.save(new LoginRecord(ip, new Date(), info, user));
        }
        return "redirect:/index";
    }

    @RequestMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

        // 生成图片
        int w = 135, h = 40;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

        // 将验证码存储在session以便登录时校验
        session.setAttribute(CAPTCHA_KEY, verifyCode.toLowerCase());
    }

}
