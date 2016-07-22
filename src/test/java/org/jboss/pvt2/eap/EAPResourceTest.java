package org.jboss.pvt2.eap;

import org.jboss.pvt2.log.PVTLogger;
import org.jboss.pvt2.utils.HttpUtils;
import org.jboss.pvt2.utils.ZipUtils;
import org.junit.*;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.logging.Logger;

/**
 * EAPResourceTest should be on the first one of the test suite, to test the sources of EAP are accessable
 * And then, make the sources ready to used by the next tests.
 * Created by yyang on 7/11/16.
 */
@Category({EAP7.class, EAP6.class})
public class EAPResourceTest {

    private static Logger logger = PVTLogger.getLogger(EAPResourceTest.class.getName());


    public EAPResourceTest(){

    }

    @BeforeClass
    public static void _setupClass(){
        logger.info("@BeforeClass _setupClass");
    }

    @AfterClass
    public static void _afterClass() {
        logger.info("@AfterClass _afterClass");
    }

    @Before
    public void _setUp() {
        logger.info("@Before _setup");
    }

    @After
    public void _teardown() {
        logger.info("@After _teardown");
    }

    @Test
    public void testConfiguration(){
        logger.info(EAP7TestSuite.EAPTestConfig.EAP_DIR_KEY + ": " + EAP7TestSuite.EAPTestConfig.getEapDir());
        Assert.assertNotNull(EAP7TestSuite.EAPTestConfig.getEapDir());

    }

    @Test
    public void testDownload() throws Exception{
        logger.info("Download EAP ZIP: " + EAP7TestSuite.EAPTestConfig.getEapZipUrl());
        HttpUtils.httpDownload(EAP7TestSuite.EAPTestConfig.getEapZipUrl());

    }

    @Test
    public void testExtract() throws Exception{
        File zipFile = new File( EAP7TestSuite.EAPTestConfig.getEapZipName());
        Assert.assertTrue(zipFile.exists());
        ZipUtils.unzip(zipFile);
    }

}


