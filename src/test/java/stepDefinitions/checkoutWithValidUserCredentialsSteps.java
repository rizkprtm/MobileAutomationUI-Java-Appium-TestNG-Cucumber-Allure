package stepDefinitions;

import com.swaglabs.pageObject.*;
import io.qameta.allure.Severity;
import io.qameta.allure.Attachment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;

public class checkoutWithValidUserCredentialsSteps {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    CartPage cartPage = new CartPage();
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @Given("User logged in with username as {string} and password as {string}")
    public void user_logged_in_valid_credentials(String validUsername, String validPassword) {
        loginPage.loginValidUser(validUsername, validPassword);
        loginPage.tapLoginBtn();
    }
    @And("Verify user already on product list page")
    public void verifyUserAlreadyOnProductListPage() {
        Assert.assertTrue(productsPage.verifyOnProductsListPage());
    }
    @When("User tap filter button")
    public void userTapFilterButton() {
        productsPage.tapFilterBtn();
    }
    @And("User set filter the list of product by price low to high")
    public void userSetFilterTheListOfProductByPriceLowToHigh() {
        productsPage.setFilterPriceLowToHigh();
        Assert.assertEquals(productsPage.verifyFilteredFirstProductPrice(), "$7.99");
    }
    @And("Verify filtered first product name")
    public void verifyFilteredFirstProductName() {
        Assert.assertTrue(productsPage.verifyFilteredFirstProductName());
    }

    @Then("User tap add to cart button from product list page")
    public void userTapAddToCartButtonFromProductListPage() {
        productsPage.tapAddToCartFromProductList();
    }

    @And("User tap filter button for the second time")
    public void userTapFilterButtonForTheSecondTime() {
        productsPage.tapFilterBtn();
    }

    @And("User set filter the list of product by price high to low")
    public void userSetFilterTheListOfProductByPriceHighToLow() {
        productsPage.setFilterPriceHighToLow();
        Assert.assertEquals(productsPage.verifyFilteredSecondProductPrice(), "$49.99");
    }

    @And("Verify filtered second product name")
    public void verifyFilteredSecondProductName() {
        Assert.assertTrue(productsPage.verifyFilteredSecondProductName());
    }

    @When("User tap second product navigate to second product details")
    public void userTapSecondProductToNavigateSecondProductDetails() {
        productsPage.navigateToSecondProductDetails();
    }

    @And("User tap add to cart button from product details page")
    public void userTapAddToCartButtonFromProductDetailsPage() throws InterruptedException {
        productDetailsPage.scrollToAddToCart();
        productDetailsPage.tapAddToCartFromProductDetailsBtn();
    }

    @Then("User tap cart button from product details page")
    public void userTapCartButtonFromProductDetailsPage() {
        productsPage.navigateToCartPage();
    }

    @And("Verify multiple products in cart page")
    public void verifyMultipleProductsInCartPage() {
        Assert.assertTrue(cartPage.verifyCartFirstItem());
        Assert.assertTrue(cartPage.verifyCartSecondItem());
    }

    @And("User tap continue shopping and redirect to product list page")
    public void userTapContinueShoppingAndRedirectToProductListPage() {
        cartPage.scrollToContinueShoppingBtn();
        cartPage.navigateToProductListFromCartPage();
    }

    @When("User tap cart button from product list page")
    public void userTapCartButtonFromProductListPage() {
        productsPage.navigateToCartPage();
    }

    @And("Verify details of the product added into the cart")
    public void verifyDetailsOfTheProductAddedIntoTheCart() {
        Assert.assertTrue(cartPage.verifyCartFirstItem());
        Assert.assertTrue(cartPage.verifyCartSecondItem());
    }

    @When("User tap checkout button navigate to checkout information page")
    public void userTapCheckoutButtonToNavigateCheckoutInformationPage() {
        cartPage.scrollToCheckoutBtn();
        cartPage.navigateToCheckoutInformationPage();
    }

    @And("User fill credentials {string} as firstName, {string} as lastName and {string} as postal code")
    public void userFillAsFirstNameAsLastNameAndAsPostalCode(String firstName, String lastName, String postal_code) {
        checkoutInformationPage.enterUserCheckoutInformation(firstName,lastName,postal_code);
    }

    @When("User tap continue checkout")
    public void userTapContinueCheckout() {
        checkoutInformationPage.tapContinueCheckout();
    }

    @And("Verify payment confirmation")
    public void verifyPaymentConfirmation() {
        checkoutOverviewPage.scrollToPaymentInformation();
        Assert.assertEquals(checkoutOverviewPage.getPaymentConfirmation(),"SauceCard #31337");
    }

    @And("Verify shipping infomation")
    public void verifyShippingInfomation() {
        checkoutOverviewPage.scrollToShippingInformation();
        Assert.assertEquals(checkoutOverviewPage.getShippingInformation(), "FREE PONY EXPRESS DELIVERY!");
    }

    @And("Verify checkout product price")
    public void verifyCheckoutProductPrice() throws InterruptedException {
        checkoutOverviewPage.scrollToPriceInformation();

        Float totalItemPrice = (Float.parseFloat(checkoutOverviewPage.getSubTotalItemPrice().substring(13)) + Float.parseFloat(checkoutOverviewPage.getTaxPrice().substring(6)));
        Float totalPrice = Float.parseFloat(checkoutOverviewPage.getTotalItemPrice().substring(8));

        Assert.assertEquals(totalItemPrice, totalPrice);
    }

    @When("User tap finish checkout navigate to complete checkout page")
    public void userTapFinishCheckoutToNavigateCompleteCheckoutPage() {
        checkoutOverviewPage.scrollToFinishCheckoutBtn();
        checkoutOverviewPage.tapFinishCheckout();
    }

    @And("Verify complete checkout message after checkout")
    public void verifyCompleteCheckoutMessageAfterCheckout() {
        Assert.assertEquals(checkoutCompletePage.verifyThankYouForYourOrder(), "THANK YOU FOR YOU ORDER");
    }

    @Then("User tap back home button")
    public void userTapBackHomeButton() {
        checkoutCompletePage.tapBackHomeBtn();
    }
}
