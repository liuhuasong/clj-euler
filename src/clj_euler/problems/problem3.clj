(ns clj-euler.problems.problem3
  (:use [clj-euler.math :only (prime-factors)]))

(def problem3 (last (prime-factors 600851475143)))