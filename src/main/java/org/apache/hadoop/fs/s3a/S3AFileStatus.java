package org.apache.hadoop.fs.s3a;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;

public class S3AFileStatus extends FileStatus {
  private boolean isEmptyDirectory;

  // Directories
  public S3AFileStatus(boolean isdir, boolean isemptydir, Path path) {
    super(0, isdir, 1, 0, 0, path);
    isEmptyDirectory = isemptydir;
  }

  // Files
  public S3AFileStatus(long length, long modification_time, Path path,
                       long blockSize) {
    super(length, false, 1, blockSize, modification_time, path);
    isEmptyDirectory = false;
  }

  public boolean isEmptyDirectory() {
    return isEmptyDirectory;
  }

  @Override
  public String getOwner() {
    return System.getProperty("user.name");
  }

  /** Compare if this object is equal to another object
   * @param   o the object to be compared.
   * @return  true if two file status has the same path name; false if not.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Returns a hash code value for the object, which is defined as
   * the hash code of the path name.
   *
   * @return  a hash code value for the path name.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /** Get the modification time of the file/directory.
   *
   * s3a uses objects as "fake" directories, which are not updated to
   * reflect the accurate modification time. We choose to report the
   * current time because some parts of the ecosystem (e.g. the
   * HistoryServer) use modification time to ignore "old" directories.
   *
   * @return for files the modification time in milliseconds since January 1,
   *         1970 UTC or for directories the current time.
   */
  @Override
  public long getModificationTime(){
    if(isDirectory()){
      return System.currentTimeMillis();
    } else {
      return super.getModificationTime();
    }
  }
}
