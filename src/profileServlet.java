import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Meng Xin
 * @Date 2020/7/10 19:05
 */
@WebServlet("/profile")
public class profileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过请求Cookie中的Session-ID去Sessoin中读取User对象，如果读到了就代表用户以及登录
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");//必须和登录的一致
        if (user == null) {
            writer.println("<p>没有登录成功，无主页</p>");
            writer.println("<p>请注册用户</p>");
        } else {
            writer.println("<p>欢迎你" + user.username + "</p>");
        }
    }
}
