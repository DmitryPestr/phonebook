package javaschool.app;

import asg.cliche.Command;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Record> recordList = new ArrayList<>();

    @Command
    public void create(String name, String email, String... phones) {
        Record r = new Record();
        r.setName(name);
        r.setEmail(email);
        r.addPhones(phones);

        recordList.add(r);
    }

    @Command
    public List<Record> list() {
        return recordList;
    }

    @Command
    public List<Record> find(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordList) {
            String name = r.getName().toLowerCase();
            String email = r.getEmail().toLowerCase();
            if (name.contains(str) || email.contains(str)) {
                result.add(r);
            } else {
                for (String p : r.getPhones()) {
                    p = p.toLowerCase();
                    if (p.contains(str)) {
                        result.add(r);
                        break;
                    }
                }
            }
        }

        return result;
    }

    @Command
    public void addPhone(int id, String phone) {
        for (Record r : recordList) {
            if (r.getId() == id) {
                r.addPhones(phone);
                break;
            }
        }
    }
}
