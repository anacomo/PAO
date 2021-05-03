package Service;

import IO.Output;
import Library.Section;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionService {
    private List<Section> sectionList;
    private static SectionService instance = null;

    private SectionService() {
        sectionList = new ArrayList<>();
    }

    public static SectionService getInstance() {
        if (instance == null)  {
            instance = new SectionService();
        }
        return instance;
    }

    public void addSection(Section section, boolean csv) {
        boolean exists = false;
        for (Section s : sectionList)
            if (s.equals(section)) {
                exists = true;
                break;
            }
        if(!exists) {
            sectionList.add(new Section(section));
            if(!csv) {
                Output.writeSectionOnCsv(section);
                Output.userAudit("Add Section");
            }
            sortSections();
        }
    }

    private void sortSections() {
        Collections.sort(sectionList);
    }

    public void showSections() {
        for (Section s : sectionList)
            System.out.println(s.toString());
    }
}
