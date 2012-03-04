(ns clj-euler.problems.problem5
  (:use [clojure.contrib.math :only (lcm)]))

(def problem5 (reduce lcm (range 1 21)))