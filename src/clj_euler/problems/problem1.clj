(ns clj-euler.problems.problem1
  (:use [clj-euler.math :only (divisible?)]))

(def problem1 (reduce + (filter #(or (divisible? % 3) (divisible? % 5)) (range 1 1000))))