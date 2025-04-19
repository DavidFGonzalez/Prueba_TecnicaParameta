package Service.utils;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class Function {

    public static Date toDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return calendar.toGregorianCalendar().getTime();
    }
}
