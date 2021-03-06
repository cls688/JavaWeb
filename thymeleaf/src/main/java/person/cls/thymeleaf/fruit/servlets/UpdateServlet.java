package person.cls.thymeleaf.fruit.servlets;

import person.cls.thymeleaf.fruit.dao.impl.FruitDAOImpl;
import person.cls.thymeleaf.fruit.pojo.Fruit;
import person.cls.thymeleaf.fruit.servlets.base.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 更新单条数据
 * @author: CLS
 * @date: 2022-06-16-14:21
 * @version: 1.0
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    private final FruitDAOImpl fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf8");

        String fidStr = req.getParameter("fid");
//        System.out.println(fidStr);
        Integer fid = Integer.parseInt(fidStr);
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");

        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
        fruitDAO.updateFruitById(fruit);

        // 浏览器重定向
        resp.sendRedirect("index");

    }
}
