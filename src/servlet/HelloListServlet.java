package servlet;

import bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import dao.HeroDao;

public class HelloListServlet extends javax.servlet.http.HttpServlet {


    public void init() {
        //初始化
    }


    public HelloListServlet(){
    //实例化
  }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //提供服务

        //request.setCharacterEncoding("UTF-8");

        List<Hero> heros = new HeroDao().list();
        request.setAttribute("heros", heros);
        request.getRequestDispatcher("listHero.jsp").forward(request, response);

    }

    public void destroy() {
        //销毁
    }
}
