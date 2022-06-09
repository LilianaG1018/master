package Orange.Definitions;

import Orange.DataExcel.ExcelReader;
import Orange.Pages.AdminPage;
import Orange.Pages.LoginPage;
import Orange.Pages.PimPage;
import Orange.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DefinitionsSteps {

    private WebDriver driver;
    private Connection conexion = new Connection();
    private LoginPage loginPage;
    private PimPage pimPage;
    private AdminPage adminPage;
    private static String employeeName;
    private static String userName;
    private static String password;
    private static String confirmPassword;
    private static String useRole;


    @Given("^open browser$")
    public void open_browser() {
        this.conexion = new Connection();
        this.driver = this.conexion.abrirNavegador();
    }

    @And("^diligenciar user (.*) y contrasena (.*)$")
    public void diligenciarLogin(String user, String pass) throws SQLException {
        this.loginPage = new LoginPage(driver);
        this.loginPage.diligenciarLogin(user, pass);
    }

    @And("^llegar a la opcion agregar empleado$")
    public void llegarAddEmployee() {
        this.pimPage = new PimPage(driver);
        this.pimPage.llegarAddEmployee();
    }

    @When("^diligenciie name (.*) y apellido (.*)$")
    public void diligenciarEmployee(String name, String lastName) throws SQLException {
        this.pimPage = new PimPage(driver);
        this.pimPage.diligenciarEmployee(name, lastName);

    }

    @And("^llegar a agregar un usuario$")
    public void llegarAddUser() {
        this.adminPage = new AdminPage(driver);
        this.adminPage.llenarAddUser();
    }

    @When("^Diligenciar el nombre de la hoja (.*) y numero de columna (.*)$")
    public void diligenciarAddUser(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        this.adminPage = new AdminPage(driver);
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testData = excelReader.getData("src/test/resources/testData/pruebasExcel.xlsx", sheetName);

        useRole= testData.get(rowNumber).get("useRole");
        employeeName = testData.get(rowNumber).get("employeeName");
        userName = testData.get(rowNumber).get("userName");
        password = testData.get(rowNumber).get("password");
        confirmPassword = testData.get(rowNumber).get("confirmPassword");
        adminPage.diligenciarAddUser(useRole,employeeName, userName, password, confirmPassword);
    }

}