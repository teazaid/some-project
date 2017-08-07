package home.assigment

/**
  * Created by Alexander on 07.08.2017.
  */
object Utils {
  type _Set = Int => Boolean

  type Predicate = Int => Boolean

  val range = 1000

  def forAll(predicate: Predicate)(set: _Set): Boolean = {

    val elementsInSetWithAppliedPredicate = (-range to range).collect {
      case element if set(element) => predicate(element)
    }

    elementsInSetWithAppliedPredicate.fold(true)(_ && _)
  }
}
