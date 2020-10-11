package com.sibytes.std

import java.io.{File, FileOutputStream, IOException, PrintWriter}
import java.nio.file.{Files, Paths}
import scala.io.Source

object IOPrintWriter extends App with Using {

  def filePut(
               path: String,
               value: String,
               lineSeparator: String = "",
               deleteIfExists: Boolean = false) = {

    if (deleteIfExists)
      Files.deleteIfExists(Paths.get(path))

    val file = new File(path)

    using(
      if (file.exists() && !file.isDirectory) {
        val outStream = new FileOutputStream(file, true)
        new PrintWriter(outStream, true)
      }
      else {
        new PrintWriter(path)
      }
    ) {
      out =>
        out.append(s"$value$lineSeparator")
        if (out.checkError()) {
          val msg = s"An error occurred writing to the file ${path}"
          throw new IOException(msg)
        }
    }
  }

  def fileRead(path: String) = {

    if (!Files.exists((Paths.get(path)))) {
      val msg = s"File doesn't not exist ${path}"
      throw new IOException(msg)
    }

    using(Source.fromFile(path)) {
      source => {
        source.getLines().mkString
      }
    }
  }

  def fileRead(path: String, fn:((String) => String)) = {

    if (!Files.exists((Paths.get(path)))) {
      val msg = s"File doesn't not exist ${path}"
      throw new IOException(msg)
    }

    using(Source.fromFile(path)) {
      source => {
        source.getLines().map(l => fn(l)).mkString
      }
    }
  }

  def fileParse(path: String, fn:((String) => String)) = {

    if (!Files.exists((Paths.get(path)))) {
      val msg = s"File doesn't not exist ${path}"
      throw new IOException(msg)
    }

    using(Source.fromFile(path)) {
      source => {
        source.getLines().flatMap(l => fn(l)).mkString
      }
    }
  }

}
