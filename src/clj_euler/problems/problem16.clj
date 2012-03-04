(ns clj-euler.problems.problem16
  (:use [clj-euler.math :only (digits)])
  (:use [clojure.contrib.math :only (expt)]))

(def problem16 (reduce + (digits (expt 2 1000))))