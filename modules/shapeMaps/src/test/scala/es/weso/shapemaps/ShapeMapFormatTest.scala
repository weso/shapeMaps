package es.weso.shapemaps
import org.scalatest._
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ShapeMapFormatTest extends AnyFunSpec with Matchers with TryValues with OptionValues {

  describe("ShapeMapFormat") {

    it("should be able to get list of available formats") {
      ShapeMapFormat.availableFormatNames should contain theSameElementsAs(List("compact","json","details"))
    }

    it(s"Should find a shapeMapFormat if it exists") {
      ShapeMapFormat.fromString("Compact").map(_.name.toLowerCase).getOrElse("failed") should be("compact")
    }

    it(s"Should not find a shapeMapFormat if it does not exist") {
      ShapeMapFormat.fromString("foo").map(_.name.toLowerCase).getOrElse("failed") should be("failed")
    }

  }


}
