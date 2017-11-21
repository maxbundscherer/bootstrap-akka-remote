# Akka Remote Bootstrap

[![Travis](https://img.shields.io/travis/rust-lang/rust.svg)](#)
[![shields.io](http://img.shields.io/badge/license-Apache2-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.txt)

**Bootstrap a akka remote backend service**

Author: Maximilian Bundscherer (https://bundscherer-online.de)

Do **not** use akka remote without akka cluster in production-mode

## Overview / Features
- Server ``MainServer`` and example client ``ExampleClient`` included
- **Docker** local publish included
- Auto-generate **coverage report(s)** (sbt-scoverage)

## Let's get started
1. See requirements!
2. Run server ``sbt run-main com.mb.bootstrap.MainServer``
3. Run example client ``sbt run-main com.mb.bootstrap.ExampleClient``
4. Have fun!

### Requirements
- SBT
- Docker (for docker local publish)

### Docker local publish
1. (Opt) Change ports in ``build.sbt``
2. (Opt) Change main class in ``build.sbt``
3. Run command ``sbt docker:publishLocal``
4. Run image ``docker run --name bootstrap-akka-remote -p 5150:5150 <IMAGE-ID>``

### Test project with coverage report(s)
1. Run test ``sbt clean coverage test``
2. Generate coverage report(s) ``sbt coverageReport``
