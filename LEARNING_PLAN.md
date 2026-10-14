# Software Engineering Learning Plan

This document is the master roadmap for the training repository.

The curriculum is cumulative: topics are introduced at the simplest useful level, then revisited later with deeper runtime, performance, architecture, and production implications.

## Progress scale

- **S0 — Not verified**
- **S1 — Basic awareness**
- **S2 — Can implement with guidance**
- **S3 — Independent practical use**
- **S4 — Strong production-level understanding**
- **S5 — Advanced**
- **S6 — Expert**
- **S7 — Ultimate / deep specialist level**

A topic is not considered mastered merely because it was read once. It must be demonstrated in code, explanation, debugging, or design work.

---

# 1. Java Language Foundations

Start from literal zero.

Core topics include:

- source-file structure;
- packages and imports;
- identifiers and naming conventions;
- primitives and reference types;
- declarations, initialization, assignment;
- local / parameter / instance / static variables;
- scopes and lifetime;
- class member layout conventions;
- constructors;
- static and instance initializer blocks;
- initialization order;
- arrays;
- primitive arrays vs wrapper collections;
- boxing / unboxing;
- numeric promotion;
- widening / narrowing conversions;
- overflow and precision;
- heap vs call-stack mental model;
- pass-by-value;
- object identity;
- garbage collection fundamentals.

Later revisit these topics at JVM/runtime depth.

---

# 2. Number Systems, Bits, Bytes, and Boolean Logic

This is a mandatory foundation track.

## Number systems

Study and practice:

- binary;
- octal;
- decimal;
- hexadecimal;
- Base32;
- Base36;
- Base58;
- Base64;
- how positional notation works;
- conversion between bases;
- Java binary, octal, decimal, hexadecimal literals;
- scientific notation;
- underscores in numeric literals.

## Binary representation

Cover:

- bit vs byte;
- signed integer representation;
- two's complement;
- positive vs negative integer bit patterns;
- overflow at the bit level;
- sign bit;
- masks and flags;
- endian concepts;
- byte ordering.

## Boolean algebra

Cover:

- NOT;
- AND;
- OR;
- XOR;
- NAND;
- NOR;
- XNOR;
- truth tables;
- De Morgan's laws;
- applying Boolean algebra to conditions and bit masks.

## Java logical and bitwise operators

Practice:

- `&&`;
- `||`;
- `!`;
- `&`;
- `|`;
- `^`;
- `~`;
- `<<`;
- `>>`;
- `>>>`;
- short-circuit vs non-short-circuit evaluation;
- signed vs unsigned shifts;
- masks;
- packed flags.

Advanced Java bit operations:

- `Integer.rotateLeft()`;
- `Integer.rotateRight()`;
- `Integer.bitCount()`;
- `Integer.numberOfLeadingZeros()`;
- `Integer.numberOfTrailingZeros()`.

Practice must include real tasks such as permissions/flags, binary protocol fields, compact state representation, hashing/mixing examples, and debugging signed shift behavior.

---

# 3. OOP and Java Type System

Progress from basic classes to full modern Java type design.

Cover:

- encapsulation;
- inheritance;
- polymorphism;
- abstraction;
- composition;
- access modifiers;
- overloading;
- overriding;
- virtual method dispatch;
- abstract classes;
- interfaces;
- default/static interface methods;
- concrete classes;
- final classes;
- sealed classes;
- non-sealed classes;
- records;
- enums;
- nested/member classes;
- static nested classes;
- inner classes;
- local classes;
- anonymous classes;
- functional interfaces;
- annotation interfaces;
- sealed interfaces;
- pattern matching;
- class hierarchy design.

Object contracts:

- `equals()`;
- equals contract;
- `hashCode()`;
- hashCode contract;
- `toString()`;
- `Comparable`;
- `Comparator`;
- cloning;
- shallow vs deep copying;
- immutability.

---

# 4. Java Collections Framework

Cover JCF in depth and through realistic engineering tasks.

Include:

- arrays vs collections;
- `List`;
- `Set`;
- `Map`;
- `Queue`;
- `Deque`;
- implementations and tradeoffs;
- iteration;
- ordering;
- sorting;
- equality and hashing;
- mutation and copying;
- views vs independent collections;
- primitive array ↔ wrapper array ↔ collection conversions;
- concurrent collections;
- complexity characteristics;
- collection selection for real problems.

---

# 5. Generics, Wildcards, and PECS

Deep mandatory track:

- generic classes;
- generic interfaces;
- generic methods;
- generic constructors;
- invariance;
- `?`;
- `? extends T`;
- `? super T`;
- PECS;
- wildcard capture;
- wildcards vs type parameters;
- bounded type parameters;
- recursive bounds;
- generic inheritance;
- raw types;
- legacy interoperability;
- type inference;
- erasure;
- bridge methods;
- reifiable vs non-reifiable types;
- heap pollution;
- generic varargs;
- `@SafeVarargs`;
- generic array restrictions;
- generic exception restrictions;
- static-member restrictions;
- overload ambiguity;
- API design with generics.

---

# 6. Exceptions and Resource Management

Cover:

- checked exceptions;
- unchecked exceptions;
- errors;
- exception hierarchy;
- `try/catch/finally`;
- `throw` vs `throws`;
- custom exceptions;
- multi-catch;
- rethrowing;
- try-with-resources;
- `AutoCloseable`;
- suppressed exceptions;
- assertions;
- production exception design.

---

# 7. Functional Java

Cover:

- lambdas;
- variable capture;
- effectively-final variables;
- functional interfaces;
- Supplier;
- Consumer / BiConsumer;
- Predicate / BiPredicate;
- Function / BiFunction;
- UnaryOperator / BinaryOperator;
- method references;
- constructor references;
- generic method references;
- Optional;
- Streams;
- primitive streams;
- collectors;
- pipeline design;
- laziness;
- side effects;
- parallel streams;
- performance implications.

---

# 8. Algorithms and Data Structures

Mandatory practical track.

Complexity:

- Big O;
- Big Theta;
- Big Omega;
- time complexity;
- space complexity;
- best / average / worst case;
- amortized analysis;
- recursion complexity.

Data structures:

- arrays;
- linked lists;
- stacks;
- queues;
- deques;
- hash tables;
- maps;
- sets;
- heaps / priority queues;
- trees;
- BSTs;
- balanced trees;
- tries;
- graphs;
- union-find / disjoint sets.

Algorithms:

- searching;
- sorting;
- hashing;
- recursion;
- backtracking;
- divide-and-conquer;
- greedy;
- dynamic programming;
- BFS;
- DFS;
- shortest paths;
- topological sort;
- minimum spanning tree.

Each structure should be both implemented manually and later used through production/library abstractions.

---

# 9. Java Binary Data, Encodings, and Byte APIs

Mandatory at intermediate/advanced level.

## Encodings and conversions

Cover:

- `HexFormat`;
- `Base64`;
- `MessageDigest`;
- `CRC32`;
- `StandardCharsets`;
- byte ↔ text conversions;
- charset mistakes;
- hashes vs checksums vs encodings.

## Buffers and binary I/O

Cover:

- `ByteBuffer`;
- heap buffers;
- direct buffers;
- `ByteBuffer.allocateDirect()`;
- byte order / endianness;
- slicing;
- typed views such as `asIntBuffer()`;
- `MappedByteBuffer`;
- `FileChannel`;
- `DataInputStream`;
- `DataOutputStream`;
- binary framing;
- zero-copy concepts;
- random access;
- memory-mapped files.

---

# 10. I/O and NIO.2

Cover:

- byte vs character streams;
- InputStream / OutputStream;
- Reader / Writer;
- buffering;
- PrintStream / PrintWriter;
- filesystem concepts;
- `Path`;
- `Files`;
- file attributes;
- directory walking;
- directory searching;
- channels;
- selectors where applicable;
- legacy `File` API for maintenance knowledge.

Native Java serialization is studied primarily for compatibility, maintenance, and security concerns rather than as the preferred modern persistence format.

---

# 11. Networking

From fundamentals to Java production networking:

- NIC / MAC / IP;
- IPv4 / IPv6;
- subnetting;
- routing;
- gateways;
- DNS;
- DHCP;
- NAT;
- ports;
- sockets;
- frames / packets / segments / datagrams;
- TCP;
- UDP;
- TCP handshake and states;
- retransmission;
- flow and congestion control;
- keepalive;
- TIME_WAIT;
- MTU and fragmentation;
- unicast / broadcast / multicast;
- HTTP/1.1;
- HTTP/2;
- HTTP/3 / QUIC;
- TLS / HTTPS;
- WebSocket;
- SSH;
- proxies;
- load balancers;
- firewalls.

Java APIs:

- `InetAddress`;
- `URI`;
- `URL`;
- `Socket`;
- `ServerSocket`;
- `DatagramSocket`;
- Java `HttpClient`;
- timeouts;
- blocking vs non-blocking I/O;
- channels/selectors;
- TLS/SSL;
- protocol framing;
- pooling;
- diagnostics and security.

---

# 12. Concurrency and Java Memory Model

Cover progressively:

- Thread;
- Runnable;
- lifecycle;
- ExecutorService;
- scheduling;
- futures;
- thread pools;
- synchronization;
- synchronized blocks/methods;
- atomics;
- concurrent collections;
- race conditions;
- visibility;
- happens-before;
- Java Memory Model;
- liveness;
- deadlock;
- starvation;
- livelock;
- Fork/Join;
- CountDownLatch;
- CyclicBarrier;
- Semaphore;
- Phaser;
- parallel reductions;
- virtual threads;
- structured concurrency concepts where appropriate.

Advanced low-level access includes `VarHandle`.

---

# 13. JVM Internals and Memory

Mandatory advanced Java track.

Cover:

- bytecode basics;
- class loading;
- linking and initialization;
- stack frames;
- operand stack;
- heap;
- metaspace;
- thread stacks;
- object headers;
- field layout;
- padding;
- alignment;
- references;
- GC roots;
- reachability;
- object lifetime;
- allocation;
- TLABs;
- escape analysis;
- scalar replacement;
- compressed ordinary object pointers;
- String pool;
- class metadata;
- GC algorithms and collectors;
- safepoints;
- JIT compilation;
- profiling-guided optimization concepts.

## Heap and object sizing

Hands-on tools/APIs:

- `Runtime.getRuntime()`;
- `Instrumentation#getObjectSize`;
- JOL;
- Jamm;
- Carrotsearch SizeOf;
- Lucene `RamUsageEstimator`.

Distinguish shallow size, retained size, logical primitive width, and physical JVM memory footprint.

---

# 14. JVM Diagnostics, Profiling, and Performance

Mandatory production-engineering track.

## Stack and thread inspection

- `Thread.getAllStackTraces()`;
- `Thread.dumpStack()`;
- `StackWalker`;
- `ThreadMXBean`.

## In-process monitoring

- `MemoryMXBean`;
- `MemoryPoolMXBean`;
- `GarbageCollectorMXBean`;
- `BufferPoolMXBean`;
- `ThreadMXBean`.

## JDK CLI tooling

- `jcmd`;
- `jmap`;
- `jstack`;
- `jstat`;
- `jinfo`;
- `jhsdb`;
- `jconsole`;
- `jfr`.

## Profiling and analysis

Core:

- Java Flight Recorder;
- Java Mission Control;
- VisualVM;
- Eclipse MAT;
- async-profiler;
- Linux `perf`;
- flame graphs;
- GC log analysis;
- JMH.

Additional commercial/production awareness:

- YourKit;
- JProfiler;
- AppDynamics;
- Dynatrace;
- New Relic;
- Datadog APM.

Container/JVM observability:

- Cryostat / ContainerJFR.

Legacy or historical tools are studied as maintenance knowledge when encountered.

---

# 15. Advanced Memory and Native Interop

Expert-level track.

Cover:

- direct/off-heap memory;
- Foreign Function & Memory API / Project Panama concepts;
- MemoryLayout;
- `VarHandle`;
- `sun.misc.Unsafe` as non-portable last-resort/legacy knowledge;
- JNI;
- JNA;
- JNR-FFI;
- native-memory lifecycle;
- pinning/copying concerns;
- crashes outside the managed heap;
- debugging native memory leaks.

---

# 16. High-Performance Byte Containers

Advanced/specialized track:

- Netty `ByteBuf`;
- Agrona `DirectBuffer`;
- Chronicle Bytes;
- pooled buffers;
- reference counting;
- flyweight patterns;
- heap vs off-heap tradeoffs;
- zero-copy slices.

These are learned after core NIO/ByteBuffer fundamentals.

---

# 17. Serialization and Binary Protocols

Core concepts:

- schema evolution;
- framing;
- compatibility;
- versioning;
- endian concerns;
- allocation costs;
- parsing costs;
- zero-copy concepts.

Advanced libraries/formats:

- Protocol Buffers;
- Avro;
- SBE;
- FlatBuffers;
- Cap'n Proto;
- Kryo;
- Protostuff;
- MessagePack;
- CBOR;
- BSON.

The goal is not to memorize libraries but to understand how to choose among them.

---

# 18. Binary Parsing DSLs

Advanced/specialized:

- Kaitai Struct;
- JBBP;
- bit fields;
- packed binary structures;
- generated parsers;
- protocol/file-format reverse engineering.

---

# 19. Bitmaps and Compact Sets

Advanced data-structure specialization:

- RoaringBitmap;
- JavaEWAH;
- compressed integer sets;
- cardinality;
- memory/performance tradeoffs;
- analytics/search use cases.

---

# 20. Compression

Understand tradeoffs among:

- LZ4;
- Zstd;
- Snappy;
- Brotli;
- GZIP/Deflate.

Practice:

- throughput vs compression ratio;
- latency;
- streaming;
- file vs network use;
- CPU/memory tradeoffs;
- benchmarking correctly.

---

# 21. Cryptography Foundations and Java Crypto Tooling

Cover safe use of:

- hashes;
- checksums vs cryptographic digests;
- randomness;
- keys;
- signatures;
- encryption concepts;
- TLS fundamentals;
- Java security APIs;
- BouncyCastle.

Cryptographic implementation details are treated as security-sensitive engineering: prefer established primitives and libraries rather than inventing algorithms.

---

# 22. Instrumentation and Bytecode Tooling

Advanced JVM track:

- `java.lang.instrument`;
- agents;
- Byte Buddy;
- ASM;
- BTrace;
- Byteman;
- JFR Event Streaming;
- runtime instrumentation;
- tracing;
- bytecode transformation.

Legacy HPROF is maintenance/history knowledge.

---

# 23. Monitoring and Observability

Cover:

- JMX;
- remote JMX;
- Jolokia;
- Micrometer;
- Prometheus;
- Grafana;
- logs;
- metrics;
- traces;
- alerting;
- SLIs/SLOs;
- dashboards;
- production diagnostics.

---

# 24. Alternative JVMs and Runtime Implementations

Awareness/advanced track:

- HotSpot;
- OpenJ9;
- Azul JVM distributions/runtime tooling;
- SAP Machine;
- vendor differences;
- GC/runtime diagnostics differences;
- choosing a JDK/runtime for production.

---

# 25. PostgreSQL

From fundamentals to advanced query planning.

Cover:

- SQL fundamentals;
- schema design;
- constraints;
- transactions;
- ACID;
- isolation levels;
- MVCC;
- locking;
- deadlocks.

## Joins

- INNER;
- LEFT;
- RIGHT;
- FULL;
- CROSS;
- self joins;
- non-equi/range joins;
- multi-table joins;
- semi joins with EXISTS;
- anti joins with NOT EXISTS;
- LATERAL;
- joins with CTEs/subqueries/windows;
- NULL semantics;
- duplicate multiplication;
- cardinality/selectivity;
- join order;
- Nested Loop;
- Hash Join;
- Merge Join;
- predicate pushdown;
- work_mem implications;
- pathological joins and redesign.

## Indexing

- B-tree;
- Hash;
- GIN;
- GiST;
- SP-GiST;
- BRIN;
- multicolumn indexes;
- leftmost-prefix behavior;
- unique indexes;
- partial indexes;
- expression indexes;
- covering indexes / INCLUDE;
- index-only scans;
- visibility map;
- selectivity/cardinality;
- operator classes;
- indexes for sorting;
- indexes for joins;
- foreign-key indexing considerations;
- HOT updates;
- write amplification;
- bloat;
- VACUUM;
- ANALYZE;
- statistics;
- unused/redundant indexes;
- CREATE INDEX CONCURRENTLY;
- REINDEX.

Optimization must be evidence-based through `EXPLAIN`, `EXPLAIN ANALYZE`, and buffers/statistics rather than blind index creation.

---

# 26. JDBC

Low-level relational access before hiding everything behind ORM:

- JDBC architecture;
- URLs;
- Connection;
- Statement;
- PreparedStatement;
- ResultSet;
- ResultSet types;
- ResultSet concurrency modes;
- transactions;
- batching;
- generated keys;
- resource closing;
- pool concepts;
- SQL injection prevention;
- performance implications.

---

# 27. Hibernate / JPA

Cover:

- persistence context;
- entity lifecycle;
- mappings;
- identifiers;
- associations;
- fetching;
- cascading;
- orphan removal;
- dirty checking;
- flush;
- first/second-level cache;
- transactions;
- locking;
- N+1;
- batching;
- query design;
- projections;
- entity equality;
- performance diagnostics.

---

# 28. Spring / Spring Boot / Security

Progress from container fundamentals to production systems:

- IoC/DI;
- bean lifecycle;
- configuration;
- profiles;
- validation;
- MVC;
- REST;
- exception handling;
- Data;
- transactions;
- Security;
- authentication;
- authorization;
- sessions;
- JWT;
- OAuth2/OIDC concepts;
- CSRF/CORS;
- method security;
- testing;
- observability;
- production configuration.

---

# 29. Linux and Server Engineering

Hands-on Linux track:

- filesystem;
- permissions;
- users/groups;
- processes;
- services;
- systemd;
- signals;
- logs;
- storage;
- networking tools;
- DNS diagnostics;
- sockets;
- ports;
- firewall;
- SSH;
- shell scripting;
- resource monitoring;
- troubleshooting;
- package management;
- server hardening.

---

# 30. Git and GitHub

Dedicated deep module plus everyday use throughout the curriculum.

Cover:

- object model: blobs, trees, commits, tags;
- working tree;
- index;
- HEAD;
- commits;
- branches;
- remotes;
- fetch;
- pull;
- push;
- merge;
- rebase;
- fast-forward;
- conflicts;
- restore;
- reset;
- revert;
- reflog;
- cherry-pick;
- bisect;
- tags;
- releases;
- hooks;
- repository hygiene;
- Conventional Commits;
- semantic versioning;
- pull requests;
- code review;
- branch protection;
- issues/projects;
- GitHub Actions;
- dependency/security scanning.

---

# 31. Docker and Containers

Cover:

- images/layers;
- Dockerfile;
- build context;
- caching;
- containers;
- volumes;
- networks;
- environment/configuration;
- health checks;
- multi-stage builds;
- Compose;
- security;
- resource limits;
- debugging;
- production image practices.

---

# 32. Kubernetes

Hands-on Linux-based track:

- kubectl;
- manifests;
- Pods;
- Deployments;
- ReplicaSets;
- Services;
- ConfigMaps;
- Secrets;
- probes;
- requests/limits;
- namespaces;
- scheduling;
- ingress;
- persistent storage;
- StatefulSets;
- Helm;
- Kustomize;
- RBAC;
- NetworkPolicy;
- autoscaling;
- rollout/rollback;
- troubleshooting;
- observability;
- networking;
- security;
- production deployment patterns.

---

# 33. CI/CD and Jenkins

Cover:

- pipelines;
- stages;
- agents;
- artifacts;
- caching;
- credentials;
- testing;
- quality gates;
- Docker integration;
- deployment;
- rollback;
- branch/PR workflows;
- GitHub Actions comparison;
- secure CI/CD.

---

# 34. AWS and Cloud Fundamentals

Cover progressively:

- IAM;
- networking/VPC;
- EC2;
- storage;
- load balancing;
- managed databases;
- DNS;
- monitoring;
- secrets;
- autoscaling;
- cost awareness;
- security;
- deployment architecture.

---

# 35. C# and .NET

Separate language/platform track from fundamentals to backend production engineering:

- language basics;
- type system;
- OOP;
- generics;
- collections;
- LINQ;
- async/await;
- memory/runtime;
- exceptions;
- testing;
- ASP.NET Core;
- dependency injection;
- EF Core;
- configuration;
- logging;
- security;
- performance;
- deployment.

---

# 36. SOLID, GRASP, Design Patterns, and Architecture

After strong OOP fundamentals:

- SOLID;
- GRASP;
- coupling/cohesion;
- dependency direction;
- boundaries;
- composition;
- dependency inversion.

Design patterns:

- creational;
- structural;
- behavioral;
- tradeoffs;
- anti-patterns;
- recognizing when a pattern is unnecessary.

System design later combines APIs, databases, caching, queues, transactions, idempotency, distributed systems, observability, scalability, failure handling, and security.

---

# 37. Training Method

Every module should contain:

- `README.md` — task specification in English;
- `THEORY.md` — theory in English;
- `THEORY_RU.md` — equivalent theory in Russian;
- `answers/ANSWERS.md` — written engineering answers;
- production-code skeleton/location;
- one independently runnable test class/source set per task;
- Gradle task such as `task1Test`, `task2Test`, etc.;
- final aggregate regression run.

Training loop:

1. Read theory.
2. Implement one task.
3. Run that task's tests immediately.
4. Commit/push work.
5. Submit commit for review.
6. Answer engineering questions.
7. Fix review findings.
8. Receive score and skill-stage update.
9. Revisit weak topics in later modules.

---

# 38. Core vs Advanced vs Specialized

Not every library has equal priority.

## Mandatory core

Examples:

- number systems and binary representation;
- bitwise operations;
- Java primitives and memory semantics;
- collections;
- generics/PECS;
- algorithms/data structures;
- JVM internals;
- ByteBuffer/NIO;
- JFR/JMC/JOL/JMH;
- networking;
- SQL/PostgreSQL;
- Spring;
- Linux;
- Git;
- Docker/Kubernetes;
- testing and observability.

## Advanced production

Examples:

- async-profiler;
- Eclipse MAT;
- JMX;
- off-heap memory;
- Foreign Memory API;
- protocol design;
- binary serialization;
- advanced PostgreSQL planning;
- runtime instrumentation.

## Specialized / elective

Examples:

- Agrona;
- Chronicle Bytes;
- SBE;
- Kaitai Struct;
- JBBP;
- JavaEWAH;
- JNA/JNR-FFI;
- alternative JVM vendor tooling.

Specialized topics are introduced when the foundational concepts they depend on are already strong.
