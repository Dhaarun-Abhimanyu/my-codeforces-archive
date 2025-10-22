from src.tabular_policy import TabularPolicy
from src.policy import PolicyIteration
from src.mdp.gridworld import GridWorld
from src.utils.plotting import show_snapshots_interactive

def main():
    # 4x3 world to match the example picture
    mdp = GridWorld(grid_size=(4, 3))
    policy = TabularPolicy(mdp.get_states())
    pi = PolicyIteration(mdp, policy)

    snapshots = []
    snapshots.append(("Initial policy", policy.policy.copy(), {}))

    # collect evaluation sweeps
    def on_eval_sweep(values_map):
        snapshots.append(("Policy Evaluation (sweep)", policy.policy.copy(), values_map.copy()))

    # collect improvement steps
    def on_improve(policy_map, values_map, iteration_idx):
        snapshots.append((f"Policy Improvement (iter {iteration_idx})", policy_map.copy(), values_map.copy()))

    iterations = pi.policy_iteration(
        max_iterations=100,
        theta=0.001,
        on_evaluation_sweep=on_eval_sweep,
        on_improvement=on_improve,
    )
    print(f"Policy iteration completed in {iterations} iterations.")

    # Final snapshot
    snapshots.append(("Final", policy.policy.copy(), snapshots[-1][2]))

    # Launch interactive viewer (click Next to step)
    show_snapshots_interactive(mdp, snapshots)

if __name__ == "__main__":
    main()