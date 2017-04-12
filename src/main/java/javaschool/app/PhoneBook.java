package javaschool.app;

import asg.cliche.Command;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;

import java.io.IOException;
import java.util.*;

public class PhoneBook implements ShellDependent {
    private Map<Integer, Record> recordList = new HashMap<>();
    private NavigableMap<String, Record> indexByName = new TreeMap<>();


    @Command
    public Collection<Record> findAfter(String str) {

    }

    @Command
    public void createPerson(String name, String email, String... phones) {
        Person r = new Person();
        r.setName(name);
        r.setEmail(email);
        r.addPhones(phones);
        recordList.put(r.getId(), r);
        indexByName.put(r.getName(), r);
    }

    @Command
    public void createNote(String name, String note) {
        Note n = new Note();
        n.setName(name);
        n.setNote(note);
        recordList.put(n.getId(), n);
    }

    @Command
    public void createReminder(String name, String txt, String time) {
        Reminder rem = new Reminder();
        rem.setName(name);
        rem.setNote(txt);
        rem.setTime(time);
        recordList.put(rem.getId(), rem);
    }

    @Command
    public Collection<Record> list() {
        return recordList.values();
    }

    @Command
    public Record show(int id) {
        return recordList.get(id);
    }

    @Command
    public List<Record> find(String str) {
        str = str.toLowerCase();
        List<Record> result = new ArrayList<>();
        for (Record r : recordList.values()) {
            if (r.contains(str)) {
                result.add(r);
            }
        }
        return result;
    }

    @Command
    public void addPhone(int id, String phone) {
        for (Record r : recordList.values()) {
            if (r instanceof Person && r.getId() == id) {
                Person p = (Person) r;
                p.addPhones(phone);
                break;
            }
        }
    }

//    @Command
//    public Record show (int id) {
//        for (Record r :recordList) {
//           if (r.getId() == id) {
//                return r;
//            }
//        }
//        return null;
//    }


    @Command
    public void edit(int id) throws IOException {
        Record r = recordList.get(id);
        ShellFactory.createSubshell("#" + id, theShell, "Edit record", r)
                .commandLoop();
    }

    private Shell theShell;

    public void cliSetShell(Shell theShell) {
        this.theShell = theShell;
    }
}
