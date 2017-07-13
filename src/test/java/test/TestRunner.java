package test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/combined_pdfs/scr_080_combined_pdf_list.feature",
//@CucumberOptions(features = "src/test/java/features/files/scr_050a_files_list.feature",
//@CucumberOptions(features = "src/test/java/features/holds/scr_071a_holds_list.feature",
//@CucumberOptions(features = "src/test/java/features/orders/scr_055b_orders_list.feature",
//@CucumberOptions(features = "src/test/java/features/overrides/scr_073a_overrides_list.feature",
//@CucumberOptions(features = "src/test/java/features/sample_orders/scr_098a_sample_order_list.feature",
glue ={"stepDefinition"})
public class TestRunner {

}
