package code.curriculum;

import java.io.File;
import code.file_handler.ReadFile;
import code.objects.Department;
import code.objects.Major;
import code.objects.School;
import code.objects.SchoolManager;

public class Data {
    public static SchoolManager SCHOOLS = null;

    public Data() {
        if (SCHOOLS == null) {
            SCHOOLS = new SchoolManager();
            try {
                String path = "assets\\data\\SCHOOLS";
                File[] schoolFolders = (new File(path)).listFiles();
                for (File schoolFolder : schoolFolders) {
                    String path1 = path + "\\" + schoolFolder.getName();
                    // Create a School instance
                    School school = new School("");

                    // Add Department to School
                    File[] departmentFolders = schoolFolder.listFiles();
                    for (File departmentFolder : departmentFolders) {
                        String path2 = path1 + "\\" + departmentFolder.getName();
                        if (departmentFolder.isFile()) {
                            // this is file txt contains name of school
                            String schoolName = ReadFile.getStringFromFile(path2);
                            school.setName(schoolName);
                        } else {
                            // this is a folder Department of school
                            // Create a Department instance
                            Department department = new Department("");

                            // Add Major to Department
                            File[] majorFolders = departmentFolder.listFiles();
                            for (File majorFolder : majorFolders) {
                                String path3 = path2 + "\\" + majorFolder.getName();
                                if (majorFolder.isFile()) {
                                    // this is a file txt contains name of department
                                    String departmentName = ReadFile.getStringFromFile(path3);
                                    department.setName(departmentName);
                                } else {
                                    // this is a folder Major of department
                                    // Create Major instance by read file data
                                    Major major = ReadFile.getMajorFromFolder(path3);
                                    // Add Major to Department
                                    department.addMajor(major);
                                }
                            }
                            // Add Department to School
                            school.addDepartment(department);
                        }
                    }
                    // Add School to SchoolManager
                    SCHOOLS.addSchool(school);
                }
            } catch (Exception e) {

            }
        }
    }

    // Get School by name
    public static School getSchool(String schoolName) {
        for (School school : SCHOOLS.getSchools()) {
            if (school.getName().equals(schoolName)) {
                return school;
            }
        }
        return null;
    }

    // Get Department by name
    public static Department getDepartment(String departmentName, School school) {
        for (Department department : school.getDepartments()) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    // Get Major by name
    public static Major getMajor(String majorName, Department department) {
        for (Major major : department.getMajors()) {
            if (major.getName().equals(majorName)) {
                return major;
            }
        }
        return null;
    }

}
