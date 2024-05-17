package Github_200days.employees_advanced_oop.main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {

    private int orgSize = 0;
    private int directReports = 0;

    private final String mngrRegex = "\\w+\\=(?<orgSize>\\w+)\\,\\w+\\=(?<dr>\\w+)";
    private final Pattern mngrPat = Pattern.compile(mngrRegex);


    public Manager(String personText) {
        super(personText);
        Matcher mgrMat = mngrPat.matcher(peopleMat.group("details"));
        if (mgrMat.find()) {
            this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            this.directReports = Integer.parseInt(mgrMat.group("dr"));

        }
    }

public int getSalary() {
    return 3500 + orgSize * directReports;
}

}
