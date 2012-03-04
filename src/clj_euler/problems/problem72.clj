(ns clj-euler.problems.problem72
  (:use [clj-euler.math :only (totient)]))

(def problem72 (reduce + (map totient (range 1 1000001))))