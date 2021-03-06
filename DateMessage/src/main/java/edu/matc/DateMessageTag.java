package edu.matc;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 *
 */
public class DateMessageTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();


        //check what time of day it is
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String greeting = "";

        //output different things depending on time of day
        if (hour >= 0 && hour < 12)
            greeting = "Good morning!";
        else if (hour >= 12 && hour < 18)
            greeting = "Good afternoon!";
        else if (hour >= 18)
            greeting = "Good evening!";

        //check if its the last day of class 2017
        if (calendar.get(Calendar.MONTH) == 4 && calendar.get(Calendar.DAY_OF_MONTH) == 9)
            greeting += " It's the last day of class!";

        //check if its halloween
        if (calendar.get(Calendar.MONTH) == 9 && calendar.get(Calendar.DAY_OF_MONTH) == 31)
            greeting += " Happy Halloween!";

        //check if its chrismas
        if (calendar.get(Calendar.MONTH) == 11 && calendar.get(Calendar.DAY_OF_MONTH) == 25)
            greeting += " Merry Christmas!";

        //print the message
        out.println(greeting);

    }
}
