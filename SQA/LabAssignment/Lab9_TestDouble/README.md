# Lab#9 – Test Double

CP353201 Software Quality Assurance (1/2569)

This folder contains both Lab#9 activities.

## Activity 9.1 – Stub (`playlist-stub-lab`)

- `MovieService` interface stands between `NowPlaying` and the external MoviePortal.
- `MovieServiceStub` returns canned playlist data (no real portal call).
- `NowPlaying` filters titles by cinema type (VIP / IMAX with Laser).

```powershell
cd playlist-stub-lab
mvn test
```

## Activity 9.2 – Mockito (`testdouble-mockito-lab`)

Source from [ChitsuthaCSKKU/SQA Lab9_TestDouble](https://github.com/ChitsuthaCSKKU/SQA/tree/2026/LabAssignment/Lab9_TestDouble).

| SUT | Dependency | Test double purpose |
|-----|------------|---------------------|
| `SeatReservation` | `SeatDAO` | Stub available seat numbers |
| `GateCheckin` | `TicketCounter` | Mock check-in customer count / status updates |

```powershell
cd testdouble-mockito-lab
mvn test
```
