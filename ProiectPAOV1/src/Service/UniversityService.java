package Service;

import IO.Output;
import Library.University;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniversityService {
    private List<University> universityList;
    private static UniversityService instance = null;

    private UniversityService() {
        universityList = new ArrayList<>();
    }

    public static UniversityService getInstance() {
        if(instance == null) {
            instance = new UniversityService();
        }
        return instance;
    }

    public void addUniversity(University university, boolean csv) {
        boolean exists = false;
        for(University u : universityList)
            if(u.equals(university)) {
                exists = true;
                break;
            }
        if(!exists) {
            universityList.add(new University(university));
            if (!csv)
            {
                Output.writeUniversityOnCsv(university);
                Output.userAudit("Add University");
            }
            sortUniversities();
        }
    }

    private void sortUniversities() {
        Collections.sort(universityList);
    }

    public void showUniversities() {
        for(University u : universityList)
            System.out.println(u.toString());
    }
}
