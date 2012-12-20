package com.pellucid.aws.s3.models;

import java.util.Date;

import play.libs.Scala;

import com.pellucid.aws.s3.models.S3Object.StorageClass;

public class Content {

    private aws.s3.models.Content scalaContent;

    private Content(aws.s3.models.Content scalaContent) {
        this.scalaContent = scalaContent;
    }

    public String id() {
        return Scala.orNull(this.scalaContent.id());
    }

    public String key() {
        return this.scalaContent.key();
    }

    public Boolean isLatest() {
        return this.scalaContent.isLatest();
    }

    public Date lastModified() {
        return this.scalaContent.lastModified();
    }

    public String etag() {
        return this.scalaContent.etag();
    }
    
    public Long size() {
        return (Long)Scala.orNull(this.scalaContent.size());
    }

    public StorageClass storageClass() {
        scala.Enumeration.Value scalaStorage = Scala.orNull(this.scalaContent.storageClass());
        if (scalaStorage == aws.s3.models.S3Object.StorageClasses$.MODULE$.STANDARD()) {
            return StorageClass.STANDARD;
        }
        return null;
    }
    
    public Owner owner() {
        return Owner.fromScala(this.scalaContent.owner());
    }

    public static Content fromScala(aws.s3.models.Content scalaContent) {
        return new Content(scalaContent);
    }

}
