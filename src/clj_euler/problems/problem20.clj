(ns clj-euler.problems.problem20
  (:use [clj-euler.math :only (fac digits)]))

(def problem20 (reduce + (digits (fac 100))))