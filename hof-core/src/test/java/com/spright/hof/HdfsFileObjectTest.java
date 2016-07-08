/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spright.hof;

import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.apache.ftpserver.ftplet.User;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import java.net.URISyntaxException;

/**
 *
 * @author user
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(HdfsOverFtpSystem.class)
public class HdfsFileObjectTest {
     
    static String stringpath="/";
    static Path path;
    static User user;
    static HdfsUser hdfsuser;

    public HdfsFileObjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, URISyntaxException {
        System.out.println("setUpClass:");
        
        path = new Path(stringpath);
        
        user = Mockito.mock(User.class);
        Mockito.when(user.getName()).thenReturn("user");
        Mockito.when(user.getPassword()).thenReturn("pwd");
        Mockito.when(user.getAuthorities()).thenReturn(null);
        Mockito.when(user.getMaxIdleTime()).thenReturn(123);
        Mockito.when(user.getHomeDirectory()).thenReturn("/home");
        Mockito.when(user.getEnabled()).thenReturn(false);
        
        HdfsOverFtpSystem hofs;
        DistributedFileSystem dfs = new DistributedFileSystem();
        Configuration conf = new Configuration();
        conf.set("testhadoop.job.ugi", "testhadoop.job.ugi,error,supergroup");
        //dfs.initialize(new URI("hdfs://localhost:9000"), conf);
        PowerMockito.mockStatic(HdfsOverFtpSystem.class);
        PowerMockito.when(HdfsOverFtpSystem.getDfs()).thenReturn(dfs);
        hdfsuser = new HdfsUser(user);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFullName method, of class HdfsFileObject.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        HdfsFileObject instance;
        instance = new HdfsFileObject(stringpath,hdfsuser);
        assertEquals("/", instance.getFullName());
    }

    /**
     * Test of getShortName method, of class HdfsFileObject.
     */
    @Test
    public void testGetShortName() {
        System.out.println("getShortName");
        HdfsFileObject instance = new HdfsFileObject(stringpath,hdfsuser);
        assertEquals("/", instance.getShortName());
    }

    /**
     * Test of isHidden method, of class HdfsFileObject.
     */
    @Test
    public void testIsHidden() {
        System.out.println("isHidden");
        HdfsFileObject instance = new HdfsFileObject(stringpath,hdfsuser);
        assertEquals(false, instance.isHidden());
    }

    /**
     * Test of isDirectory method, of class HdfsFileObject.
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    /*@Test
    public void testIsDirectory() throws IOException, URISyntaxException {
        System.out.println("isDirectory");
        HdfsFileObject instance = new HdfsFileObject(stringpath,hdfsuser);
        assertEquals(fs.isDir(), instance.isDirectory());
    }*/

    /**
     * Test of isFile method, of class HdfsFileObject.
     */
    /*@Test
    public void testIsFile() {
        System.out.println("isFile");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.isFile();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of doesExist method, of class HdfsFileObject.
     */
    /*@Test
    public void testDoesExist() {
        System.out.println("doesExist");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.doesExist();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of hasReadPermission method, of class HdfsFileObject.
     */
    /*@Test
    public void testHasReadPermission() {
        System.out.println("hasReadPermission");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.hasReadPermission();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of hasWritePermission method, of class HdfsFileObject.
     */
    /*@Test
    public void testHasWritePermission() {
        System.out.println("hasWritePermission");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.hasWritePermission();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of hasDeletePermission method, of class HdfsFileObject.
     */
    /*@Test
    public void testHasDeletePermission() {
        System.out.println("hasDeletePermission");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.hasDeletePermission();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getOwnerName method, of class HdfsFileObject.
     */
    /*@Test
    public void testGetOwnerName() {
        System.out.println("getOwnerName");
        HdfsFileObject instance = null;
        String expResult = "";
        String result = instance.getOwnerName();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getGroupName method, of class HdfsFileObject.
     */
    /*@Test
    public void testGetGroupName() throws IOException, URISyntaxException {
        System.out.println("getGroupName");
        HdfsFileObject instance = new HdfsFileObject(stringpath,hdfsuser);        
        
        //FileStatus fs = dfs.getFileStatus(path);
        assertEquals(fs.getGroup(), instance.getGroupName());
    }*/

    /**
     * Test of getLinkCount method, of class HdfsFileObject.
     */
    /*@Test
    public void testGetLinkCount() {
        System.out.println("getLinkCount");
        HdfsFileObject instance = null;
        int expResult = 0;
        int result = instance.getLinkCount();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getLastModified method, of class HdfsFileObject.
     */
    /*@Test
    public void testGetLastModified() {
        System.out.println("getLastModified");
        HdfsFileObject instance = null;
        long expResult = 0L;
        long result = instance.getLastModified();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of getSize method, of class HdfsFileObject.
     */
    /*@Test
    public void testGetSize() {
        System.out.println("getSize");
        HdfsFileObject instance = null;
        long expResult = 0L;
        long result = instance.getSize();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of mkdir method, of class HdfsFileObject.
     */
    /*@Test
    public void testMkdir() {
        System.out.println("mkdir");
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.mkdir();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of delete method, of class HdfsFileObject.
    /*@Test
    public void testDelete() throws IOException, URISyntaxException {
        System.out.println("delete");
        HdfsFileObject instance = new HdfsFileObject(stringpath,hdfsuser);

        boolean expResult = false;
        assertEquals(expResult, instance.delete());
    }*/

    /**
     * Test of move method, of class HdfsFileObject.
     */
    /*@Test
    public void testMove() {
        System.out.println("move");
        FileObject fileObject = null;
        HdfsFileObject instance = null;
        boolean expResult = false;
        boolean result = instance.move(fileObject);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of listFiles method, of class HdfsFileObject.
     */
    /*@Test
    public void testListFiles() {
        System.out.println("listFiles");
        HdfsFileObject instance = null;
        FileObject[] expResult = null;
        FileObject[] result = instance.listFiles();
        assertArrayEquals(expResult, result);
    }*/

    /**
     * Test of createOutputStream method, of class HdfsFileObject.
     */
    /*@Test
    public void testCreateOutputStream() throws Exception {
        System.out.println("createOutputStream");
        long l = 0L;
        HdfsFileObject instance = null;
        OutputStream expResult = null;
        OutputStream result = instance.createOutputStream(l);
        assertEquals(expResult, result);
    }*/

    /**
     * Test of createInputStream method, of class HdfsFileObject.
     */
    /*@Test
    public void testCreateInputStream() throws Exception {
        System.out.println("createInputStream");
        long l = 0L;
        HdfsFileObject instance = null;
        InputStream expResult = null;
        InputStream result = instance.createInputStream(l);
        assertEquals(expResult, result);
    }*/
    
}
