package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.awaitility.Awaitility;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.DownloadPage;

import java.io.File;

import static java.util.concurrent.TimeUnit.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDownloadingfiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;
    File downloadFile;

    @Test
    public void weCanDownloadAFileToOurHardDrive(){
        downloadPage.open();

        downloadPage.downloadSampleFile();

        downloadFile = new File(System.getenv("TEMP") + "\\sample.png");
//        File downloadFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();

        Awaitility.await()
                .atMost(15, SECONDS)
                .until(
                        downloadFile::exists
                );

        System.out.println(downloadFile);
        assertThat(downloadFile).exists();
        assertThat(downloadFile.getName()).isEqualTo("sample.png");
    }

    @After
    public void cleanup()
    {
        downloadFile.delete();
    }
}
