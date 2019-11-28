package com.fdfs;

import org.csource.fastdfs.*;

/**
 * @author xt
 * @create 2019/11/29 1:46
 * @Desc
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 1. 加载配置文件
        ClientGlobal.init("D:\\ideaProjects\\fastDFStest\\src\\main\\resources\\fdfs_client.conf");

        // 2. 构建一个管理客户端
        TrackerClient client = new TrackerClient();

        // 3. 连接管理者服务端
        TrackerServer trackerServer = client.getConnection();

        // 4.声明存储服务端
        StorageServer storageServer = null;
        
        // 5. 获取存储服务器的客户端对象
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        /**
         * 6. 上传文件
         * 参数：文件名、文件类型、扩展信息
         */
        String[] strings = storageClient.upload_file("D:\\madara.jpg", "jpg", null);

        // 7. 显示上传结果 file_id
        for (String string : strings) {
            System.out.println(string);
        }

        /**
         * group1
         * M00/00/00/wKjvDV3gfF6APVBhAABWsFeZdl8709.jpg
         */
    }
}
