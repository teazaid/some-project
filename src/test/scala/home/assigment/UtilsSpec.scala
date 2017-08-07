package home.assigment

import org.scalatest.FunSuite

/**
  * Created by Alexander on 07.08.2017.
  */
class UtilsSpec extends FunSuite {

  import Utils._

  test("testForAll returns true") {
    val predicate1: Predicate = i => i >= -range && i <= range
    val set1: _Set = i => i >= -range && i <= range
    assert(forAll(predicate1)(set1))

    val predicate2: Predicate = i => Set(1, 2, 3, 4, 5, 6).contains(i)
    val set2: _Set = i => Set(1, 2, 3, 4, 5).contains(i)
    assert(forAll(predicate2)(set2))

    val predicate3: Predicate = i => i >= -range && i <= range
    val set3: _Set = i => i >= -range && i <= range - 100
    assert(forAll(predicate3)(set3))

    val predicate4: Predicate = i => true
    val set4: _Set = i => true
    assert(forAll(predicate4)(set4))

    val predicate5: Predicate = i => i == range
    val set5: _Set = i => i == range
    assert(forAll(predicate5)(set5))

    val predicate6: Predicate = i => i == -range
    val set6: _Set = i => i == -range
    assert(forAll(predicate6)(set6))
  }

  test("testForAll returns false") {
    val predicate1: Predicate = i => i >= -range && i <= range - 1
    val set1: _Set = i => i >= -range && i <= range
    assert(!forAll(predicate1)(set1))

    val predicate2: Predicate = i => Set(1, 2, 3).contains(i)
    val set2: _Set = i => Set(1, 2, 3, 4, 5).contains(i)
    assert(!forAll(predicate2)(set2))

    val predicate3: Predicate = i => i == 1000
    val set3: _Set = i => i == 20
    assert(!forAll(predicate3)(set3))

    val predicate4: Predicate = i => false
    val set4: _Set = i => true
    assert(!forAll(predicate4)(set4))
  }

}
