(ns clj-euler.problems.problem4
  (:use [clj-euler.math :only (palindromic?)]))

(def problem4 (apply max (filter palindromic? (for [a (range 1 1000) b (range 1 1000)] (* a b)))))