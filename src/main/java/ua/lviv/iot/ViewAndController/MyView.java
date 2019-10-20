package ua.lviv.iot.ViewAndController;

import ua.lviv.iot.connectionProperty.ConnectionManager;
import ua.lviv.iot.model.CandidateLevelEntity;
import ua.lviv.iot.model.VacancyInfoHasUserInfoEntity;
import ua.lviv.iot.model.metadata.TableMetaData;
import ua.lviv.iot.service.CandidateLevelService;
import ua.lviv.iot.service.MetaDataService;
import ua.lviv.iot.service.VacancyInfoHasUserInfoService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: candidate_level");
        menu.put("11", "  11 - Create for candidate_level");
        menu.put("12", "  12 - Update candidate_level");
        menu.put("13", "  13 - Delete from candidate_level");
        menu.put("14", "  14 - Select candidate_level");
        menu.put("15", "  15 - Find candidate_level by ID");

        menu.put("2", "   2 - Table: contact_person_info");
        menu.put("21", "  21 - Create for contact_person_info");
        menu.put("22", "  22 - Update contact_person_info");
        menu.put("23", "  23 - Delete from contact_person_info");
        menu.put("24", "  24 - Select contact_person_info");
        menu.put("25", "  25 - Find contact_person_info by ID");

        menu.put("3", "   3 - Table: it_company_info");
        menu.put("31", "  31 - Create for it_company_info");
        menu.put("32", "  32 - Update it_company_info");
        menu.put("33", "  33 - Delete from it_company_info");
        menu.put("34", "  34 - Select it_company_info");
        menu.put("35", "  35 - Find it_company_info by ID");

        menu.put("4", "   4 - Table: language");
        menu.put("41", "  41 - Create for language");
        menu.put("42", "  42 - Update language");
        menu.put("43", "  43 - Delete from language");
        menu.put("44", "  44 - Select language");
        menu.put("45", "  45 - Find language by ID");

        menu.put("5", "   5 - Table: level_of_experience");
        menu.put("51", "  51 - Create for level_of_experience");
        menu.put("52", "  52 - Update level_of_experience");
        menu.put("53", "  53 - Delete from level_of_experience");
        menu.put("54", "  54 - Select level_of_experience");
        menu.put("55", "  55 - Find level_of_experience by ID");

        menu.put("6", "   6 - Table: technical_level");
        menu.put("61", "  61 - Create for technical_level");
        menu.put("62", "  62 - Update technical_level");
        menu.put("63", "  63 - Delete from technical_level");
        menu.put("64", "  64 - Select technical_level");
        menu.put("65", "  65 - Find technical_level by ID");

        menu.put("7", "   7 - Table: user_info");
        menu.put("71", "  71 - Create for user_info");
        menu.put("72", "  72 - Update user_info");
        menu.put("73", "  73 - Delete from user_info");
        menu.put("74", "  74 - Select user_info");
        menu.put("75", "  75 - Find user_info by ID");

        menu.put("8", "   8 - Table: user_private_info");
        menu.put("81", "  81 - Create for user_private_info");
        menu.put("82", "  82 - Update user_private_info");
        menu.put("83", "  83 - Delete from user_private_info");
        menu.put("84", "  84 - Select user_private_info");
        menu.put("85", "  85 - Find user_private_info by ID");

        menu.put("9", "   4 - Table: vacancy_info");
        menu.put("91", "  41 - Create for vacancy_info");
        menu.put("92", "  42 - Update vacancy_info");
        menu.put("93", "  43 - Delete from vacancy_info");
        menu.put("94", "  44 - Select vacancy_info");
        menu.put("95", "  45 - Find vacancy_info by ID");

        menu.put("10", "   10 - Table: vacancy_info_has_user_info");
        menu.put("101", "  101 - Create for vacancy_info_has_user_info");
        menu.put("102", "  102 - Update vacancy_info_has_user_info");
        menu.put("103", "  103 - Delete from vacancy_info_has_user_info");
        menu.put("104", "  104 - Select vacancy_info_has_user_info");
        menu.put("105", "  105 - Find vacancy_info_has_user_info by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::takeStructureOfDB);

        methodsMenu.put("11", this::createForCandidateLevel);
        methodsMenu.put("12", this::updateCandidateLevel);
        methodsMenu.put("13", this::deleteFromCandidateLevel);
        methodsMenu.put("14", this::selectCandidateLevel);
        methodsMenu.put("15", this::findCandidateLevelByID);

    }

    private void selectAllTable() throws SQLException {
        selectCandidateLevel();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: " + connection.getCatalog());
        for (TableMetaData table : tables) {
            System.out.println(table);
        }
    }

    private void createForCandidateLevel() throws SQLException {
        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        System.out.println("Input level for CandidateLevel: ");
        String level = input.nextLine();
        CandidateLevelEntity entity = new CandidateLevelEntity(id, level);
        CandidateLevelService candidateLevelService = new CandidateLevelService();
        candidateLevelService.create(entity);
    }

    private void updateCandidateLevel() throws SQLException {
        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        System.out.println("Input level for CandidateLevel: ");
        String level = input.next();
        if (check(id)) {
            CandidateLevelEntity candidateLevelEntity = new CandidateLevelEntity(id, level);
            CandidateLevelService candidateLevelService = new CandidateLevelService();
            candidateLevelService.update(candidateLevelEntity);
        } else {
            System.out.println("you can't update level, when even one candidate has that level");
        }
    }

    private void selectCandidateLevel() throws SQLException {
        System.out.println("\nTable: CandidateLevel");
        CandidateLevelService departmentService = new CandidateLevelService();
        List<CandidateLevelEntity> departments = departmentService.findAll();
        for (CandidateLevelEntity entity : departments) {
            System.out.println(entity);
        }
    }

    private void findCandidateLevelByID() throws SQLException {
        System.out.println("Input ID for CandidateLevel: ");
        Integer id = input.nextInt();
        CandidateLevelService departmentService = new CandidateLevelService();
        CandidateLevelEntity entity = CandidateLevelService.findById(id);
        System.out.println(entity);
    }

    private void deleteFromCandidateLevel() throws SQLException {
        System.out.println("Input ID for this CandidateLevel: ");
        Integer idDeleted = input.nextInt();
        if (check(idDeleted)) {
            CandidateLevelService candidateLevelService = new CandidateLevelService();
            candidateLevelService.delete(idDeleted);
        } else {
            System.out.println("you can't delete level, when even one candidate has that level");
        }
    }

    private boolean check(Integer id) throws SQLException {
        VacancyInfoHasUserInfoService service = new VacancyInfoHasUserInfoService();
        List<VacancyInfoHasUserInfoEntity> entities = service.findAll();
        boolean check = false;
        for (VacancyInfoHasUserInfoEntity entity : entities) {
            if (entity.getCandidateLevelId() == id) {
                check = false;
            } else {
                check = true;
            }
        }
        return check;
    }

    //------------------------------------------------------------------------



    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
