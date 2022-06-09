package Orange.Pages;

import Orange.BaseDatos.ConsultaBaseDatos;
import Orange.BaseDatos.InsertEmployee;
import Orange.Steps.ButtonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;

public class PimPage {

    private ButtonPages buttonPages;
    private ConsultaBaseDatos consultaBaseDatos;
    private InsertEmployee insertEmployee;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement txtName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement txtApellido;

    public PimPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.buttonPages = new ButtonPages(driver);

    }

    public void llegarAddEmployee() {
        buttonPages.btnPim();
        buttonPages.btnAddEmployee();
    }

    public void diligenciarEmployee(String name, String lastName) throws SQLException {
        txtName.sendKeys(name);
        txtApellido.sendKeys(lastName);
        buttonPages.btnSave();
        insertEmployee.insertAddEmployee(name, lastName);
    }
}
