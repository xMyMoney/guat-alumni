package com.zwx.guatalumni.common.utils;


import ch.qos.logback.core.util.FileUtil;
import com.zwx.guatalumni.common.constant.CommonConstant;
import com.zwx.guatalumni.common.constant.FileType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author: zhaoy
 * @date: 2018/4/28
 * @version: 1.0
 * @Description:
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 保存文件
     *
     * @param filePath
     * @param fileContent
     * @return
     */
    public static boolean saveFile(String filePath, String fileContent) {
        boolean result = true;
        File file = new File(filePath);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("新建文件失败 error : path : " + filePath + ", " + e.getMessage());
                result = false;
            }
        }
        if (file.isFile()) {
            FileOutputStream fos = null;
            OutputStreamWriter osw = null;
            try {
                fos = new FileOutputStream(file, true);     //追加方式写入
                osw = new OutputStreamWriter(fos, "UTF-8");
                osw.write(fileContent);
                osw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                logger.error("文件没找到 error : " + e.getMessage());
                result = false;
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("保存文件 IO error : " + e.getMessage());
                result = false;
            } finally {
                if (fos != null) try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error("保存文件 IO error : " + e.getMessage());
                    result = false;
                }
                if (osw != null) {
                    try {
                        osw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("保存文件 IO error : " + e.getMessage());
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 保存文件
     *
     * @param filePath
     * @param tempFile
     * @return
     */
    public static boolean saveFile(String filePath, File tempFile) {
        boolean result = true;
        File file = new File(filePath);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();

        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream(file);
            fis = new FileInputStream(tempFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            result = true;
        } catch (Exception exp) {
            exp.printStackTrace();
            logger.error("维保记录操作 : " + exp.getMessage());
            result = false;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * 根据当前时间生成临时文件名称
     *
     * @param extName 文件扩展名
     * @return
     */
    public static String getTempFileNameByCurrentDate(String extName) {
        Random random = new Random();
        String fileName = DateTimeHelper.dateToString(new Date(), "yyyyMMddHHmmssSSS") + "_" + random.nextInt(1000) + extName;
        return fileName;
    }

    /**
     * 保存Base64字符为文件
     *
     * @param filePath
     * @param base64Code
     * @return
     */
    public static boolean saveFileFromBase64(String filePath, String base64Code) {
        boolean result = true;
        File file = new File(filePath);
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();

        FileOutputStream fos = null;
        byte[] buffers = null;
        try {
            fos = new FileOutputStream(file);
            buffers = new BASE64Decoder().decodeBuffer(base64Code);
            fos.write(buffers);
            result = true;
        } catch (Exception exp) {
            exp.printStackTrace();
            logger.error("维保记录操作 : " + exp.getMessage());
            result = false;
        } finally {
            if (buffers != null) {
                buffers = null;
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }

    public static boolean saveFileTo(File inFile, String file2) {
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        try {
            //创建两个文件
            //
            File outFile = new File(file2);
            //最大的流为60Mb,当文件的容量大于60Mb的时候便分开流
            final int MAX_BYTE = 60000000;
            long streamTotal = 0;  //接受流的容量
            int streamNum = 0;  //流需要分开的数量
            int leave = 0;  //文件剩下的字符数
            byte[] inOutb;  //byte数组接受文件的数据
            //创建流文件读入与写出类
            inStream = new FileInputStream(inFile);
            outStream = new FileOutputStream(outFile);
            //通过available方法取得流的最大字符数
            streamTotal = inStream.available();
            //取得流文件需要分开的数量
            streamNum = (int) Math.floor(streamTotal / MAX_BYTE);
            //分开文件之后,剩余的数量
            leave = (int) streamTotal % MAX_BYTE;
            //文件的容量大于60Mb时进入循环
            if (streamNum > 0) {
                for (int i = 0; i < streamNum; ++i) {
                    inOutb = new byte[MAX_BYTE];
                    //读入流,保存在byte数组
                    inStream.read(inOutb, 0, MAX_BYTE);
                    outStream.write(inOutb);  //写出流
                    outStream.flush();  //更新写出的结果
                }
            }
            //写出剩下的流数据
            inOutb = new byte[leave];
            inStream.read(inOutb, 0, leave);
            outStream.write(inOutb);
            outStream.flush();

        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            if (outStream != null) {
                try {
                    outStream.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        }
        return true;
    }


    /**
     * 获取文件的MD5
     *
     * @param file
     * @return
     */
    public static String generateFileMD5(File file) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            FileChannel ch = in.getChannel();
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            messagedigest.update(byteBuffer);

            byte[] bytes = messagedigest.digest();

            StringBuffer sb = new StringBuffer(2 * bytes.length);
            int k = bytes.length;
            for (int l = 0; l < k; l++) {
                char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
                char c1 = hexDigits[bytes[l] & 0xf];
                sb.append(c0);
                sb.append(c1);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 创建新的文件
     *
     * @param filePath 路径+文件名称
     * @return
     */
    public static boolean createFile(String filePath) {
        boolean result = false;
        File file = new File(filePath);
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            return result;
        }
        if (!file.exists()) {
            try {
                result = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 创建临时的Excel文件
     *
     * @param fileType 文件扩展名
     * @return
     */
    public static TempFileVo createTempFile(String fileType) {
        TempFileVo tempFileVo = null;
        // 生成临时文件名称和路径
        String fileName = UUID.randomUUID().toString();
        String filePath = CommonUtil.getProjectRootPath(FileUtil.class) + CommonConstant.DOWNLOAD_TEMP_PATH + fileName + fileType;
        File file = new File(filePath);

        //父文件夹存在，清空24小时之前的临时文件
        if (file.getParentFile().exists()) {
            long currTime = System.currentTimeMillis();
            // 当前目录中修改时间在24个小时之前文件
            File[] oldFiles = file.getParentFile().listFiles();
            for (File oldFile : oldFiles) {
                if (StringUtils.isNoneBlank(oldFile.getName()) && (currTime - oldFile.lastModified()) > 24 * 60 * 60 * 1000) {
                    // 创建时间离当前时间至少24个小时，则删除
                    oldFile.delete();
                }
            }
        } else {
            if (!file.getParentFile().mkdirs()) {   //创建父文件夹
                return null;
            }
        }

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    tempFileVo = new TempFileVo();
                    tempFileVo.setFileName(fileName);
                    tempFileVo.setFileAbsolutePath(filePath);
                    tempFileVo.setFileRelativePath(CommonConstant.DOWNLOAD_TEMP_PATH + fileName + fileType);
                    tempFileVo.setFileType(fileType);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tempFileVo;
    }

    /**
     * 创建临时的Excel文件
     *
     * @param sourceFilePath 文件扩展名
     * @return
     */
    public static TempFileVo copyExcelTemplateFile(String sourceFilePath) {

        TempFileVo tempFileVo = createTempFile(FileType.XLS.getExtendName());
        if (tempFileVo != null) {

            BufferedInputStream inBuff = null;
            BufferedOutputStream outBuff = null;
            try {
                // 新建文件输入流并对它进行缓冲
                inBuff = new BufferedInputStream(new FileInputStream(new File(CommonUtil.getProjectRootPath(FileUtil.class) + sourceFilePath)));

                // 新建文件输出流并对它进行缓冲
                outBuff = new BufferedOutputStream(new FileOutputStream(new File(tempFileVo.getFileAbsolutePath())));

                // 缓冲数组
                byte[] b = new byte[1024 * 5];
                int len;
                while ((len = inBuff.read(b)) != -1) {
                    outBuff.write(b, 0, len);
                }
                // 刷新此缓冲的输出流
                outBuff.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭流
                if (inBuff != null)
                    try {
                        inBuff.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                if (outBuff != null)
                    try {
                        outBuff.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        return tempFileVo;
    }

    private final static int bufferLen = 1024;

    /**
     * 读取文件流中的内容，不删除文件
     *
     * @param in
     * @param tmpFile
     * @return
     * @throws IOException
     */
    public static String readStreamNoDelete(InputStream in, File tmpFile) throws IOException {
        //
        String ret = "";
        BufferedInputStream bufIn = null;
        try {
            bufIn = new BufferedInputStream(in);

            // 读取文件内容，因为是完整的utf-8 ，所以必须先写入到文件中，然后读取文件内容，然后删除临时文件

            StringBuilder sb = new StringBuilder();

            System.out.println("tmpfilename:" + tmpFile.getName());

            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(tmpFile));

            int count;
            byte data[] = new byte[bufferLen];
            while ((count = bufIn.read(data, 0, bufferLen)) != -1) {
                bos.write(data, 0, count);
            }
            bos.close();


            //读取文件
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tmpFile), "UTF-8"));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();


            //删除文件
            //tmpFile.delete();

            ret = sb.toString();
        } catch (Exception exp) {
            exp.printStackTrace();
            logger.error("exp :" + exp.getMessage());
        } finally {

            if (bufIn != null) {
                bufIn.close();
            }
        }
        return ret;
    }
}