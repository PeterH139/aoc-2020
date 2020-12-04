(ns days.three
  (:require [clojure.string :as str]))

(def test-input
  ["..##......."
   "#...#...#.."
   ".#....#..#."
   "..#.#...#.#"
   ".#...##..#."
   "..#.##....."
   ".#.#.#....#"
   ".#........#"
   "#.##...#..."
   "#...##....#"
   ".#..#...#.#"])

(def question-input
  ["...#...###......##.#..#.....##."
   "..#.#.#....#.##.#......#.#....#"
   "......#.....#......#....#...##."
   "...#.....##.#..#........##....."
   "...##...##...#...#....###....#."
   "...##...##.......#....#...#.#.."
   "..............##..#..#........#"
   "#.#....#.........#...##.#.#.#.#"
   ".#..##......#.#......#...#....#"
   "#....#..#.#.....#..#...#...#..."
   "#.#.#.....##.....#.........#..."
   "......###..#....#..#..#.#....#."
   "##.####...#.............#.##..#"
   "....#....#..#......#.......#..."
   "...#.......#.#..#.........##.#."
   "......#.#.....###.###..###..#.."
   "##..##.......#.#.....#..#....#."
   "..##.#..#....#.............##.#"
   "....#.#.#..#..#........##....#."
   ".....####..#..#.###..#....##..#"
   "#.#.......#...##.##.##..#....#."
   ".#..#..##...####.#......#..#..."
   "#...##.......#...####......##.."
   "...#.####....#.#...###.#.#...#."
   "....#...........#.##.##.#......"
   ".....##...#.######.#..#....#..#"
   ".#....#...##....#..######....#."
   "...#.....#...#####.##...#..#.#."
   ".....#...##........##.##.##.###"
   "#.#..#....##....#......#....#.#"
   "......##...#.........#....#.#.."
   "###..#..##......##.#####.###.##"
   "#.....#..##.##....#...........#"
   "##..#.#..##..#.#.....#......#.."
   ".#.##.#..#.#....##..#..#....#.."
   ".#......##..##.#...#..#.......#"
   "#....##.##..###..###......##.#."
   "....###..##.......#.###.#....#."
   "..##........#........##.....#.."
   ".#..#.....#...####.##...##....."
   "....#.#.#.....#.##..##.....#..#"
   "..............#.....#...#.....#"
   ".#.....#......###...........#.#"
   ".....#.#......#.##..#.........."
   ".#......###............#.#.##.."
   ".#.#....##.#..###.....#.##..#.#"
   ".......#.#.#..#..#..#...##..#.#"
   ".#.###...##.#.#.####.#.#...#..."
   "...#.#....#......##.##.#......."
   "#...#.....##....#........##...."
   ".....###...#.##.#......##.#..#."
   "..#...##.##.###..#..#......####"
   ".#.##.#..#.##..##..........##.."
   "..#.#.#..#.#.....#...###.....#."
   "..#..#.#....#.##.............##"
   ".......#..###..#.#...#.....##.#"
   "####.#.#......#..#.##.........#"
   "..........#.....#..##......###."
   "..#..............#...#..##....."
   "......#.#.#..#.##.....####..##."
   ".##.#..#.#....#.......#..#....."
   "..#..#..#.##.#....###.#.#.#.#.#"
   ".....#....#......###..#........"
   "#.#.#..#...###.....#......#.##."
   "...#.#....#.#......#........#.."
   "..#...###.#...#..#....##...#..#"
   ".###.##..#..#...###.#..#.####.."
   "#....#..##..##..#......#...##.."
   "#.#..#...#..#...###..#.#.##...."
   "##....#....##.####...#.#.###..."
   "##.#...#.......#.##.##....#...#"
   "..#.#..........#..#.#.#....#..#"
   "..#........#...#....#....#....#"
   "..#..#....#.......#........#..."
   "......#....#....##.#....#.#.##."
   ".##...###.##.##....##.#...###.."
   ".....##..#.#.....###..#.....###"
   "....##.#.##...##..##........#.."
   "#...#..##.#.#....#......#...#.."
   ".###.##.#........#.####....#..."
   "#.##.....#..#...#..##.##..#.#.."
   ".....#.#..#....#..#...##.##.#.."
   ".#......#####...##...#.#.###.#."
   "#......##....#.....#......##.#."
   "#.#.##.###.#......#####..#....."
   "........###.#...#..#.#........#"
   "....#....###..#.##.#...#....#.."
   "..........#..#.#....#...#.#...#"
   "#.##......###.#.#.#....####...#"
   "...#.#....#........##.#.....##."
   ".....##..#.#.#..###...##...#..."
   "#...#...#....#....##........#.."
   ".....#.........##.#......#..#.."
   "#.....##..#.###.....#....##.##."
   "...#..#..#.#........##...##.#.#"
   "..#..##.###.....#.#.....###.##."
   "..###.........#...##.....###..."
   "...###...##.#...##....##......."
   ".#.#..#...###..#.#....#....#..."
   "##..#.......#....#.#...#..#..#."
   "..#......#....####..##..#.###.#"
   "..#.......##........#.#.#..#..."
   ".#.......#.##.#.##.#.......#..#"
   "###...#...#...#...#..#...#...##"
   "..#..........#..###........##.."
   ".##..#....##......##........#.#"
   "......#.##......#......##...#.#"
   ".#.#....#.#.#........#......#.."
   ".#.#..#....####..##...##....#.."
   ".#...##..#..#..#####....##.#..."
   ".##.#.#...#...#.#...#.##.#...#."
   "###.#...##..#.###.#.....#.##.#."
   "#.....#.###.#.#...#..#....#.#.."
   "..##..#....#......#.........###"
   ".#...#...##......#...#.####...."
   "..#.##...##..............#.#..#"
   "..#......#..##...........#..#.#"
   "..#####...#..#.......##...###.."
   "..##..#....#.#...###.#...#....."
   "..#....#..#.#.......#..#.#.#..."
   ".##..#.#.....##....#.......#..."
   "...#.#..###...##....#....##..#."
   ".....##..#...##.####....##...#."
   ".......#.........#...#.##..####"
   "........###..#..#.##.###..#...."
   ".#.#..#.##.##.........#...#...."
   ".###......#.....#....##....####"
   ".##..##...........#.....#.....#"
   "#.#.#.#.#.#.##..#.#.#..#.##...."
   ".##.##...##..#....##..###..####"
   "#..##.#......#...###.........#."
   "#..#...#..##..#..##.....##...#."
   "#...##..#...##.#.###.#...#....."
   ".###.....#.......#...#.##.###.#"
   "..........#.#......#...###...##"
   "..##....#.#..#....#.###...#..##"
   "#.#..#....##.##..##.........##."
   "#.....#.##.###.#..#....##...#.."
   "...#........##...#..###..######"
   "#..#.#.#.#...#....#....###.#..#"
   "...##.##.##.....##..#........#."
   "..#.#....#..#.......#...##.##.#"
   "###.##.......##..#.####...#.#.."
   "....#.#.....##.....#.#.##...#.."
   ".#..##..#.....#.#..#...#..#..#."
   ".###....##...#......#.....#...."
   "##.##.###......#...#...###.#..."
   "#...#.##...#.#....##.....####.."
   "#.#.#.#...###...##............."
   "..#....#.....##.#...#......#..."
   "....#...#......#...#..#...#.#.."
   ".###..#.....#..#...#....#...#.."
   "..#...#.#..###.......#..#.#...#"
   "#...###.##.....#....#..#.#..##."
   "...#.##.#.##......#.#.#.##....."
   "........####...##...##..#....#."
   ".#.#....#....#.#...##.###...##."
   "#.#...###.#.#.#....#....#.#...."
   ".####.#..#.#....#..#.#..#..#..."
   "#####...#...#...#....#.#.#..##."
   "..###.##.###...#..........#.##."
   "##.....#...#....###..###.#.#.#."
   "#..##.#..#..#..#...#.#...###..#"
   "##....#.#...##......#.#...#...#"
   ".##..........#.#....#...#.##..#"
   "....#....####.#.####......#.###"
   "..##.#.....####.#.####.......#."
   "#.##.##.#.....#.##......##...#."
   "......###..#.....#.....##......"
   "..#..#....#.#...#.....#......##"
   "##..#..#..###.#.#..#..##.....#."
   "#....#.#.....#####...#.#......."
   ".....#..#....#.#.#..#...#...#.."
   "............#.##......##.##.#.#"
   "....#...#.#........###....#...."
   "..#..#...###.#....##..#..###.##"
   "#.##....#...#.....##..#.##.#..."
   "...##..###...#.#.....##.#......"
   ".#..#.##.#####..#.......#..###."
   "...#.##...###.....####.#.#....."
   ".#......##.#.#.#.#.##.#.....#.."
   "..#.##.#..##.......#.#.....##.."
   "..................#....#...#..."
   ".##.#..#.#.#..#.......#.#..##.#"
   "....#........#......#..####..#."
   "#...#...##..##.#..#.......##..."
   "#..#..#..#..#........####..#.#."
   "..#.#......#..#.##.##.#.#...#.#"
   "...#..#......#.#.###.#.##..##.."
   "..#...##.....#..#...##..#.#...."
   "#.........#....#..#....##.##..#"
   "..#..#.#....#..#...#.##.....#.."
   "...#..#...#.#.....#..##..#.#..."
   "....#........#.#....##..##..#.."
   "#.....#.#..#.......#.##.....#.."
   ".#.###.###...##...##..###...#.."
   ".##.##.......#.#......#.....#.#"
   "...#....##....#..#..........#.#"
   "..#.##.........#.#.....#.....#."
   "...#.##..##.......##..##...#..."
   "#.##......##.##..#.....##...##."
   "#.#.#..##...#.#............#.#."
   "....#.....#......##...#.#.....#"
   "...#.#......#.#...###.......#.."
   "......##..###....#.#...#.#####."
   "..#..#.#.#...##.#...###..##..#."
   "##.##.#.#.##.#..#....#...#...#."
   "#..#....######.##.#...#...#.#.."
   ".#..#.##....#..#.#.......#....#"
   "....#....#......##....##.#.#..."
   ".###......#..#..#.......####..#"
   ".#.#.....#..###...........##..."
   ".##..##.##.....####..#..#..##.."
   "..#..##.#......#...###.##..#.#."
   "....##..#.....###..#.##....##.#"
   "#..#......#....#.........#....."
   ".#...#.....#.#..#..##....#....."
   ".##..#...#..##.#..#...........#"
   "..#..##........##.......#..#..."
   "#.....#....#....#.#.#...##.#..."
   "...#...#.#.#..#.##.#.#...#....."
   "..#..#.#....#....###....#.#.#.."
   "...###..#...#..#....#.....#...."
   "...#...#.#..#.....#...###......"
   "##......#..........#.#.#..#.#.#"
   "....#.....#.....#..#..#.#.#.#.."
   "...####...#.##...#.#..#....#.#."
   "#.##........##.............#.##"
   "#.#.#.#.#.....................#"
   ".#.###....#..##.##.##....#....."
   "#.#...#.####.###...#..#..#.#..."
   ".##...#..###.......##..#.#....."
   "#.#.#.#...#...#.##.....#......."
   ".##.#.#.#......####..#.#......."
   "###..........#......#...##...#."
   ".........##...#.##...#.#......."
   "...#.#.....#...#..#...#..##..#."
   ".#..###...#.#.........###....#."
   "##..#...#........#.........##.."
   ".....#...#.#...#.#.#..........."
   "..#....##...#.#..#..#.##....##."
   ".##....#.#.....##.#..#..#...##."
   "..##......#.#...#.#.......##.#."
   "##...#..#...##.#........#.##..."
   "#......#.##..#.#..#.###.......#"
   "#.#...#.....#.#......#.#.#....."
   "#.....#..#.......#....##.#.#..#"
   "###.#....#..##.#.##....#....#.."
   "#.##.##....#.#..#.#...#....#..."
   "####...#####...#.....#....##.#."
   "....#.#...#.#.##.#.#.##.#.#.###"
   "#.....##.#.....#.#......#.#..#."
   ".#....##.#..#........#...##.#.."
   "......#...#....##....##....##.."
   "..###.....#....##.#...#..#....."
   "#....##...##.##..##.#...#...#.."
   "#..#...#...#.#....##..#.#....#."
   "......................#.....#.."
   ".#..#...#.........#....##...###"
   ".##.#.#...##...#...#...#..#...."
   ".#.###....#.#............##..#."
   "###..##.#.#.#.#....##...#......"
   ".##................####...##.##"
   ".#.#.........##....#.#.##.##.#."
   "....#...#...#...##...#.##.#..#."
   ".#.#........#..##.....#..#....#"
   "##.#..#.#....#.....#...#...#..."
   ".#...##....#.....##....#..#.#.#"
   "####.....#..#....#......###.##."
   "##..##.#....###.....#...#......"
   ".##.#...#.....#.#..#.#..#.#...#"
   ".....#.#..#..#..###.#...###.#.."
   ".#.#.##.#..#.#..#...#..#......."
   "..#.....#....#.##.##.##.......#"
   ".#..##....###...#.............."
   "#....#...#.#.......#....##.#..."
   "....#.#..##.#....#..#.#....#.#."
   "#.........##...#.#............."
   "#.#.......##.....#...##..##.#.#"
   ".......#....#..##...#..#######."
   ".#.#...##........#..#.....#.#.."
   ".#.......#..#......#.##.##...##"
   ".........#............#....#..#"
   ".#......#...##...##...#....###."
   ".........#...#.#.###.......#..."
   "###.#..#.#.#.#......##...#.#..."
   ".#.........##.#....###....#.#.."
   "#.#....#..#.##.#..#....##...#.."
   "###.#...#..#..##........#.###.."
   ".....#....#..#........#..#.##.#"
   "..#.....##......#....#..#.#.#.."
   ".#.........#.....#.....#......."
   "......#....#.###..#.#....#....#"
   "..#.#..#.#.###.........#..#..#."
   "..#..#.#.#.........#....##.#.#."
   "#.......#........##...##....#.."
   "##..#..#...###...#..##..#..#.#."
   "##..#..#....#.#..##..#..#.#..#."
   "..##.....##.#..#.#........###.."
   "..#.#..#..##........#...#....##"
   ".##..#....##..#..#..#..#.#....#"
   "#....#.....##........#.....#.##"
   "......#....#.#..#......#.##...."
   ".......#..#..#......##........."
   "......#...#..##.....#......#..#"
   "#..#..#....##....#........##..#"
   "##....#...#.#.....#####........"
   "...#.#..#.#.##.#.##..##...#...."
   "..#..#..#..#..#....#..#..##...#"
   ".#.....#....##.##....##.....#.."
   "#...#.....#.....#.#...#.#....#."
   ".###...#..##....#..#...#.###..."
   "....#..##..#.......#.##.##..###"
   "#.......##.....#.......#.#...##"
   "#.....#.#.#....#.#......#.#.#.."
   "..##.....#..###......##........"
   ".....#...#..##....#......#....."
   "#..#..#....#.#...#..###.......#"
   ".....#.....#....#..#...#.#..##."
   "#####........#...#..#..##..#.#."
   ".#..#...#.##....#.#..#......###"
   "#.###.#..#.....##..##....#...#."
   ".#...#.#####....##..........##."])

(defn tree-hits [[across down] input]
  (->> (map #(str/split % #"") input)
       (apply mapv vector)
       repeat
       flatten
       (take-nth (+ down (* across (count input))))
       (take (/ (count input) down))
       (filter #(= % "#"))
       count))

(defn question-1-answer [] (tree-hits [3 1] question-input))

(defn question-2-answer []
  (->> [[1 1] [3 1] [5 1] [7 1] [1 2]]
       (map #(tree-hits % question-input))
       (apply *)))
