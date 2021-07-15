package com.hlzt.file;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package com.changgou.file *
 * @since 1.0
 */
@Data
@Accessors(chain = true)
public class FastDFSFile implements Serializable {

    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;

}
