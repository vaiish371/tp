package seedu.duke.data;

import seedu.duke.Module;

import java.util.ArrayList;

public class Data {
    public ArrayList<Module> modules;

    public Data() {
        this.modules = new ArrayList<>();
    }

    public Data(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public void add(Module module) {
        modules.add(module);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public Module find(String moduleCode) {
        for (Module module : modules) {
            if (module.getModuleCode().equals(moduleCode)) {
                return module;
            }
        }
        return null;
    }

    public void remove(String moduleCode) {
        for (Module module : modules) {
            if (module.getModuleCode().equals(moduleCode)) {
                modules.remove(module);
                return;
            }
        }
    }
}
