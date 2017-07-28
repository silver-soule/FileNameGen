package edu.knoldus

//import org.scalatest.FunSuite
import org.scalatest.AsyncFunSuite
/**
  * Created by Neelaksh on 25/7/17.
  */
class FileNameGenTest extends AsyncFunSuite {

  test("testGetFileName") {
    val listOfNames = FileNameGen.generateFilenameList("/home/gitika/IdeaProjects/FileNameGen/src/test/resources/filenames")
    listOfNames.map{
      actualList=> assert(actualList ==List("/home/gitika/IdeaProjects/FileNameGen/src/test/resources/filenames/1.txt",
                                          "/home/gitika/IdeaProjects/FileNameGen/src/test/resources/filenames/abc.txt",
                                            "/home/gitika/IdeaProjects/FileNameGen/src/test/resources/filenames/dirto/2.txt"))
    }
  }

  test("exception"){
    recoverToSucceededIf[NullPointerException]  {
      FileNameGen.generateFilenameList("/home/gitika/IdeaProjects/FileNameGen/src/test/resources/invalid")
    }
  }

}
