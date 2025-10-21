# Policy Iteration Sample

This project implements the Policy Iteration algorithm, a fundamental method in reinforcement learning for finding the optimal policy in Markov Decision Processes (MDPs). The implementation is structured in a modular way, allowing for easy understanding and extension.

## Overview

The Policy Iteration algorithm consists of two main steps: policy evaluation and policy improvement. The algorithm iteratively evaluates the current policy and improves it until convergence to the optimal policy is achieved.

## Project Structure

- `src/`: Contains the main source code for the project.
  - `main.py`: Entry point for running the policy iteration algorithm.
  - `policy.py`: Implements the `PolicyIteration` class.
  - `tabular_policy.py`: Defines the `TabularPolicy` class for managing policies.
  - `tabular_value_function.py`: Implements the `TabularValueFunction` class for state values.
  - `qtable.py`: Manages Q-values for state-action pairs.
  - `mdp/`: Contains MDP-related classes.
    - `gridworld.py`: Defines the `GridWorld` class for a grid world environment.
  - `utils/`: Contains utility functions.
    - `plotting.py`: Functions for plotting results.

- `tests/`: Contains unit tests for the implementation.
  - `test_policy_iteration.py`: Tests for the policy iteration algorithm.

- `requirements.txt`: Lists the dependencies required for the project.

- `.gitignore`: Specifies files and directories to be ignored by Git.

## How to Run

1. Clone the repository:
   ```
   git clone <repository-url>
   cd policy-iteration-sample
   ```

2. Install the required dependencies:
   ```
   pip install -r requirements.txt
   ```

3. Run the sample implementation:
   ```
   python src/main.py
   ```

## Dependencies

This project requires the following Python packages:
- numpy
- matplotlib

## License

This project is licensed under the MIT License. See the LICENSE file for more details.