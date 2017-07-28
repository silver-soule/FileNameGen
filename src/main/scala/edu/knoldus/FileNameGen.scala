package edu.knoldus

import java.io.{File, FileNotFoundException}

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Neelaksh on 25/7/17.
  */
object FileNameGen {
  def generateFilenameList(inputDir: String): Future[List[String]] = {
    Future {
      @tailrec
      def getFileName(inputDir: List[String], accFiles: List[String]): List[String] = {
        inputDir match {
          case head :: tail => getFileName(tail ::: new File(head). listFiles(_.isDirectory).toList.map(_.getAbsolutePath),
                          accFiles ::: new File(head).listFiles().toList.filter(_.isFile).map(_.getAbsolutePath))
          case _ => accFiles
        }
      }
      getFileName(List(inputDir), Nil)
    }
  }
}
