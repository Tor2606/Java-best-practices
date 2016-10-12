package CopyAndMoveFilesAndDirectories;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyAndMoveDirectoryVisitor extends SimpleFileVisitor<Path> {
/*    One of the more interesting and useful methods found in the Files class is Files.walkFileTree. The walkFileTree method performs a depth first traversal of a file.xml tree. There are two signatures:
    walkFileTree(Path start,Set options,int maxDepth,FileVisitor visitor)
    walkFileTree(Path start,FileVisitor visitor)
    The second option for Files.walkFileTree calls the first option with EnumSet.noneOf(FileVisitOption.class) and Integer.MAX_VALUE. As of this writing, there is only one file.xml visit option – FOLLOW_LINKS. The FileVisitor is an interface that has four methods defined:
    preVisitDirectory(T dir, BasicFileAttributes attrs) called for a directory before all entires are traversed.
            visitFile(T file.xml, BasicFileAttributes attrs) called for a file.xml in the directory.
            postVisitDirectory(T dir, IOException exc) only called after all files and sub-directories have been traversed.
    visitFileFailed(T file.xml, IOException exc) called for files that could not be visited*/

    /*All of the methods return one of the four possible FileVisitResult enums :
    FileVistitResult.CONTINUE
    FileVistitResult.SKIP_SIBLINGS (continue without traversing siblings of the directory or file.xml)
            FileVistitResult.SKIP_SUBTREE (continue without traversing contents of the directory)
    FileVistitResult.TERMINATE*/

    private Path fromPath;
    private Path toPath;
    private StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path targetPath = toPath.resolve(fromPath.relativize(dir));
        if (!Files.exists(targetPath)) {
            Files.createDirectory(targetPath);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
        return FileVisitResult.CONTINUE;
    }
}

