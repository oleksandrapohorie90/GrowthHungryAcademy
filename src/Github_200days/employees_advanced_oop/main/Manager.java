package Github_200days.employees_advanced_oop.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int orgSize = 0;
    private int directReports = 0;

    private final String mngrRegex = "\\w+\\=(?<orgSize>\\w+)\\,\\w+\\=(?<dr>\\w+)";
    private final Pattern mngrPat = Pattern.compile(mngrRegex);
    private final String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(regex);
    private final DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("M/d/yyyy");


    public Manager(String personText) {
        Matcher peopleMat = peoplePat.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtformatter.parse(peopleMat.group("dob")));
            Matcher mgrMat = mngrPat.matcher(peopleMat.group("details"));
            if (mgrMat.find()) {
                this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
                this.directReports = Integer.parseInt(mgrMat.group("dr"));

            }
        }
    }
}
