package web;

import entity.Person;
import entity.SearchType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchCriteria = req.getParameter("searchCriteria");
        String searchType = req.getParameter("searchType");
        PrintWriter out = resp.getWriter();

        if (searchCriteria == null || searchCriteria.equals("")) {
            out.println("Search criteria is mandatory!");
            req.getRequestDispatcher("index.html"); }
        else if (searchType == null || searchType.equals("") ||
                !(searchType.equals("mandatory") || searchType.equals("optional"))) {
            out.println("Search type is mandatory!");
            req.getRequestDispatcher("index.html"); }
        else {
            HttpSession session = req.getSession();
            List<Person> personList = (List<Person>) session.getAttribute(searchCriteria);
            SearchType type = (searchType.equals("mandatory") ? SearchType.MANDATORY : SearchType.OPTIONAL);
            if (personList == null) {
                SocketClient client = new SocketClient(searchCriteria, type);
                Set<Person> personSet = client.getPersons();
                personList = new ArrayList<>(personSet);
                personList.sort(new RateComparator());
                session.setAttribute(searchCriteria, personList); }
            for (Person person : personList) {out.println(person);}
        }
    }
}