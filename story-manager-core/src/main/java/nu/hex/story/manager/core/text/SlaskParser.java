package nu.hex.story.manager.core.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 2016-okt-24
 *
 * @author hl
 */
public class SlaskParser {

    private final String text;

    public SlaskParser(String text) {
        this.text = text;
    }

    public String extractTitle() {
        Matcher matcher = Pattern.compile("<title>(.*?)</title>").matcher(text);
        while (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static void main(String[] args) {
        String content = "﻿<html>\n" +
"    <head>\n" +
"        <title>Välkommen!</title>\n" +
"\n" +
"        <style type=\"text/css\">\n" +
"\n" +
"\n" +
"            a {\n" +
"                text-decoration: none !important;\n" +
"                color: #4482c3;\n" +
"            }\n" +
"\n" +
"\n" +
"            p {\n" +
"                line-height: 118%;\n" +
"                font-family: \"open sans\", verdana, Arial, Helvetica, sans-serif;\n" +
"                font-size: 104%;\n" +
"            }\n" +
"        </style>\n" +
"    </head>\n" +
"    <body bgcolor=\"#eeeeee\">\n" +
"        <span style=\"display: none !important; font-size: 0px; color: #d6d6d9;\">\n" +
"            Björn Lundén Information\n" +
"        </span>\n" +
"\n" +
"        <table style=\"padding-right: 40px; padding-left: 40px;\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"510\" align=\"center\" bgcolor=\"#FFFFFF\">\n" +
"\n" +
"            <tr>\n" +
"\n" +
"                <td align=\"left\" width=\"510\">\n" +
"                    <font face=\"Verdana, Arial, Helvetica, sans-serif\" color=\"#000000\"> \n" +
"                    <br/>\n" +
"                    <p style=\"text-align:center;\">\n" +
"                        <img src=\"https://download.blinfo.se/v2/public/BL-loggan_230.jpg\" width=\"230\" height=\"\" alt=\"Björn Lundén Information\">\n" +
"                        <!--<div style=\"border-top:1px solid #858585; width:90%; margin:0 auto; text-align:center;\">\n" +
"                         &nbsp;\n" +
"                        </div>-->\n" +
"                    </p>\n" +
"                    </font>\n" +
"                    <!-- tips från supporten-logga-->\n" +
"                    <br>\n" +
"\n" +
"                    <!--<h2 align=\"left\">\n" +
"                  <font face=\"Arial, Helvetica, sans-serif\" color=\"#4f4f4f\" size=\"5\">\n" +
"                     Lorem\n" +
"                            </font>\n" +
"                            \n" +
"                           <font face=\"Arial, Helvetica, sans-serif\" color=\"#4f4f4f\" size=\"3\">\n" +
"                               <br>– lorem ipsum\n" +
"                            </font>\n" +
"         \n" +
"               </h2>-->\n" +
"\n" +
"\n" +
"                    <p align=\"left\">\n" +
"                        <font face=\"open sans, Arial, Helvetica, sans-serif\" color=\"#000000\">\n" +
"                        <br/>\n" +
"                        Hej!<br>\n" +
"                        <br>\n" +
"                        Du har nu fått tillgång till BL Byråstöd.\n" +
"                        <br>\n" +
"                        Välkommen som användare av BL Byråstöd!\n" +
"                        </font>\n" +
"                    </p>\n" +
"\n" +
"                </td>	\n" +
"            </tr> \n" +
"\n" +
"            <tr> \n" +
"                <td valign=\"top\" align=\"left\"> \n" +
"                    <br>\n" +
"                    <hr>\n" +
"                    <!-- BÖRJAN SIDFOT -->			\n" +
"                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\n" +
"                        <tr bgcolor=\"#ffffff\">\n" +
"                            <td style=\"line-height: 14px; font-size: 14px; font-family: tahoma, verdana, Arial, Helvetica, sans-serif; color:#565656;\" align=\"center\" height=\"\" >\n" +
"                                <br> <br>  	 \n" +
"\n" +
"                                <b>Björn Lundén Information AB</b>\n" +
"                                <br/><br/>\n" +
"\n" +
"                                <a style=\"text-decoration:none;\" href=\"mailto:info@blinfo.se\"><font color=\"#565656\" style=\"font-size: 13px\">info@blinfo.se</a></font>&nbsp;\n" +
"                                •  <font color=\"#565656\" style=\"font-size: 13px\">Tfn:&nbsp;0650&#x2011;54&nbsp;14&nbsp;00</font>				\n" +
"                                <br/><br/>	\n" +
"\n" +
"\n" +
"                                <font style=\"font-size: 20px; font-family: tahoma, arial, Helvetica, sans-serif; line-height: 26px;\">\n" +
"                                <a href=\"http://www.blinfo.se\" style=\"text-decoration: none\"><font color=\"#4482c3\"><b>www.blinfo.se</b></font></a>  \n" +
"                                </font>		 \n" +
"                                <br/><br/>\n" +
"\n" +
"\n" +
"                                <!-- sociala medier ikonerna-->		\n" +
"                                <a href=\"https://www.facebook.com/blinfo\" style=\"font-size: 11px; line-height: 18px; font-family:Arial, Helvetica, sans-serif; color:#bba374;\">\n" +
"                                    <img src=\"http://img.anpdm.com/BL_edr/facebook.png\" width=\"24\" height=\"\" align=\"center\" link=\"\" style=\"border-style: none\"/>\n" +
"                                </a>\n" +
"\n" +
"                                <img src=\"http://customers.anpdm.com/shared/images/pixel.gif\" width=\"10\" height=\"1\" />		\n" +
"\n" +
"                                <a href=\"https://www.youtube.com/user/bjornlundeninfo\" style=\"font-size: 11px; line-height: 18px; font-family:Arial, Helvetica, sans-serif; color:#bba374;\">	 \n" +
"                                    <img src=\"http://img.anpdm.com/BL_edr/you_tube.png\" width=\"24\" height=\"\" align=\"center\" style=\"border-style: none\" link=\"\" />\n" +
"                                </a>\n" +
"\n" +
"                                <img src=\"http://customers.anpdm.com/shared/images/pixel.gif\" width=\"10\" height=\"1\" />\n" +
"\n" +
"                                <a href=\"https://twitter.com/bjornlundeninfo\" style=\"font-size: 11px; line-height: 18px; font-family:Arial, Helvetica, sans-serif; color:#bba374;\">		\n" +
"                                    <img src=\"http://img.anpdm.com/BL_edr/twitter.png\" width=\"24\" height=\"\" align=\"center\" style=\"border-style: none\" link=\"\" />\n" +
"                                </a>	\n" +
"\n" +
"                                <img src=\"http://customers.anpdm.com/shared/images/pixel.gif\" width=\"10\" height=\"1\" />\n" +
"\n" +
"                                <a href=\"https://instagram.com/bjornlundeninfo/\" style=\"font-size: 11px; line-height: 18px; font-family:Arial, Helvetica, sans-serif; color:#bba374;\">			\n" +
"                                    <img src=\"http://img.anpdm.com/BL_edr/instagram.png\" width=\"24\" height=\"\" style=\"border-style: none\" align=\"center\" link=\"\" />\n" +
"                                </a>	\n" +
"                                <br/><br/>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"                                <br> <br><br>\n" +
"\n" +
"                            </td>\n" +
"                        </tr>\n" +
"                    </table>   \n" +
"                    <!-- SLUT SIDFOT -->\n" +
"                </td>\n" +
"            </tr>\n" +
"        </table>\n" +
"    </body>\n" +
"</html>";
        String subject = new SlaskParser(content).extractTitle();
        System.out.println(subject);
    }

}
